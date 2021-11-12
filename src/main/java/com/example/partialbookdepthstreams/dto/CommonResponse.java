package com.example.partialbookdepthstreams.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResponse implements Serializable {
    private String stream;
    private StreamResponseDto data;

    public StreamResponseDto getData() {
        return data;
    }

    public CommonResponse setData(StreamResponseDto data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "stream='" + stream + '\'' +
                ", data=" + data +
                '}';
    }

    public String getStream() {
        return stream;
    }

    public CommonResponse setStream(String stream) {
        this.stream = stream;
        return this;
    }
}
