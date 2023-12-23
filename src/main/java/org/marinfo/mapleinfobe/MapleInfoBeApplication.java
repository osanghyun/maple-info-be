package org.marinfo.mapleinfobe;

import org.marinfo.mapleinfobe.config.MarinfoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.TimeZone;


@ConfigurationPropertiesScan
@SpringBootApplication
public class MapleInfoBeApplication {
    private static MarinfoConfig config;

    public static MarinfoConfig config() {
         return config;
    }

    public static void main(String[] args) {
        var ctx = SpringApplication.run(MapleInfoBeApplication.class, args);

        config = ctx.getBean(MarinfoConfig.class);
        TimeZone.setDefault(TimeZone.getTimeZone(config.getTimeZone()));
    }

}
