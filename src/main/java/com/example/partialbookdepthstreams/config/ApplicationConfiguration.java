package com.example.partialbookdepthstreams.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ApplicationConfiguration {

    private static String binanceSocketUrl;
    private static String binanceDepthUrl;

    public static String getBinanceSocketUrl() {
        return binanceSocketUrl;
    }

    @Value("${binance.socketUrl}")
    public void setBinanceSocketUrl(String binanceSocketUrl) {
        ApplicationConfiguration.binanceSocketUrl = binanceSocketUrl;
    }

    @Value("${binance.depthUrl}")
    public void setBinanceDepthUrl(String binanceDepthUrl) {
        ApplicationConfiguration.binanceDepthUrl = binanceDepthUrl;
    }

    public static String getBinanceDepthUrl() {
        return binanceDepthUrl;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setReadTimeout(Duration.ofMinutes(1))
                .setConnectTimeout(Duration.ofMinutes(1))
                .build();
    }
}
