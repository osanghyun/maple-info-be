package org.marinfo.mapleinfobe.util;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.marinfo.mapleinfobe.MapleInfoBeApplication;
import org.marinfo.mapleinfobe.exception.NexonOpenApiException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class NexonOpenApiClientUtil {
    private static final RestClient restClient = initializeRestClient();

    public static <T> T httpGetRequest(ParameterizedTypeReference<T> ref, String subPath, MultiValueMap<String, String> queryParams) {
        var uri = UriComponentsBuilder
                .fromPath(subPath)
                .queryParams(queryParams)
                .build(false)
                .toString();

        return restClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    if (response.getStatusCode().is2xxSuccessful()) {
                        return Objects.requireNonNull(response.bodyTo(ref));
                    }
                    else {
                        var error = response.bodyTo(ApiErrorResult.class);
                        if (error != null && error.getError() != null) {
                            var message = error.getError().getMessage();
                            var name = error.getError().getName();
                            errorResponseLogger(request.getMethod(), request.getURI().toString(), name, message);
                            throw new NexonOpenApiException(name, message);
                        }
                        else {
                            throw new NexonOpenApiException();
                        }
                    }
                });

    }

    @Getter
    @Setter
    public static class ApiErrorResult{
        private ErrorResult error;

        @Getter
        @Setter
        private static class ErrorResult {
            private String name;
            private String message;
        }
    }

    private static RestClient initializeRestClient() {
        var factory = new DefaultUriBuilderFactory(MapleInfoBeApplication.config().getNexonOpenApi().getUrl());
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

        return RestClient.builder()
                .uriBuilderFactory(factory)
                .defaultHeader(MapleInfoBeApplication.config().getNexonOpenApi().getAuthHeader(),
                        MapleInfoBeApplication.config().getNexonOpenApi().getAuthKey())
                .requestInterceptor(new RestClientRequestInterceptor())
                .build();
    }

    private static class RestClientRequestInterceptor implements ClientHttpRequestInterceptor {
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            var method = request.getMethod();
            var uri = request.getURI();
            var headers = request.getHeaders();
            log.info("\n====================================================================================================\nUri : {}) {}\nHeader: {}\n====================================================================================================", method, uri, headers);
            return execution.execute(request, body);
        }
    }

    private static void errorResponseLogger(HttpMethod httpMethod, String url, String errorName, String message) {
        log.error("\n====================================================================================================\nUri : {}) {}\nerrorName: {}\nmessage : {}\n====================================================================================================", new Object[]{httpMethod, url, errorName, message});
    }

}
