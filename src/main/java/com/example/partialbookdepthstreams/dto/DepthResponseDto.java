package com.example.partialbookdepthstreams.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthResponseDto implements Serializable {
    private Long lastUpdateId;
    @JsonProperty("E")
    private Long E;
    @JsonProperty("T")
    private Long T;
    private String symbol;
    private String pair;
    private List<List<String>> bids;
    private List<List<String>> asks;

    public Long getLastUpdateId() {
        return lastUpdateId;
    }

    public DepthResponseDto setLastUpdateId(Long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
        return this;
    }

    public Long getE() {
        return E;
    }

    public DepthResponseDto setE(Long e) {
        E = e;
        return this;
    }

    public Long getT() {
        return T;
    }

    public DepthResponseDto setT(Long t) {
        T = t;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public DepthResponseDto setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getPair() {
        return pair;
    }

    public DepthResponseDto setPair(String pair) {
        this.pair = pair;
        return this;
    }

    public List<List<String>> getBids() {
        return bids;
    }

    public DepthResponseDto setBids(List<List<String>> bids) {
        this.bids = bids;
        return this;
    }

    public List<List<String>> getAsks() {
        return asks;
    }

    public DepthResponseDto setAsks(List<List<String>> asks) {
        this.asks = asks;
        return this;
    }
}
