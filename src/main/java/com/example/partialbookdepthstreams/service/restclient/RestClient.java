package com.example.partialbookdepthstreams.service.restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

@Service
public class RestClient {

    private final RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T exec(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }

    public <T> T getForObject(String url, Class<T> tClass) {
        return exec(() -> restTemplate.getForObject(url, tClass));
    }
}
