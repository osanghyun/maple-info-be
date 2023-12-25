package org.marinfo.mapleinfobe.util;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.marinfo.mapleinfobe.MapleInfoBeApplication;
import org.marinfo.mapleinfobe.exception.NexonOpenApiException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
public class NexonOpenApiClientUtil {
    private static final WebClient webClient = initializeWebClient();
    private static final String NEXON_BASE_URL = MapleInfoBeApplication.config().getNexonOpenApi().getUrl();
    private static final String NEXON_AUTH_HEADER = MapleInfoBeApplication.config().getNexonOpenApi().getAuthHeader();
    private static final String NEXON_AUTH_KEY = MapleInfoBeApplication.config().getNexonOpenApi().getAuthKey();

    public static <T> T httpGetRequest(ParameterizedTypeReference<T> ref, String subPath, MultiValueMap<String, String> queryParams) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(NEXON_BASE_URL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

        var uri = factory
                .uriString(subPath)
                .queryParams(queryParams)
                .toUriString();

        return webClient.get()
                .uri(uri)
                .header(NEXON_AUTH_HEADER, NEXON_AUTH_KEY)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(ref);
                    }
                    else {
                        return response.bodyToMono(ApiErrorResult.class).flatMap(errorResult -> {
                            var message = errorResult.getError().getMessage();
                            var name = errorResult.getError().getName();
                            errorResponseLogger(HttpMethod.GET, uri, name, message);
                            return Mono.error(new NexonOpenApiException(name, message));
                        });
                    }
                })
                .blockOptional()
                .orElseThrow(NexonOpenApiException::new);
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

    private static WebClient initializeWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(10))
                        .addHandlerLast(new WriteTimeoutHandler(10)))
                .responseTimeout(Duration.ofSeconds(2));

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .filter(logRequest())
                .build();
    }

    private static void errorResponseLogger(HttpMethod httpMethod, String url, String errorName, String message) {
        log.error("\n====================================================================================================\nUri : {}) {}\nerrorName: {}\nmessage : {}\n====================================================================================================", new Object[]{httpMethod, url, errorName, message});
    }

    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("\n====================================================================================================\nUri : {}) {}\nHeader: {}\n====================================================================================================", new Object[]{clientRequest.method(), clientRequest.url(), clientRequest.headers()});
            return Mono.just(clientRequest);
        });
    }

}
