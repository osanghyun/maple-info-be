package org.marinfo.mapleinfobe.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(value = "marinfo")
public class MarinfoConfig {

    private String timeZone;
    private NexonOpenApi nexonOpenApi;

    @Getter
    @Setter
    @ToString
    public static class NexonOpenApi {
        private String url;
        private String authHeader;
        private String authKey;
    }
}
