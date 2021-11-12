package com.example.partialbookdepthstreams.dto;

import com.example.partialbookdepthstreams.entity.StreamEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamResponseDto implements Serializable {

    @JsonProperty("e")
    private String e;
    @JsonProperty("E")
    private Long E;
    @JsonProperty("T")
    private Long T;
    @JsonProperty("s")
    private String s;
    @JsonProperty("ps")
    private String ps;
    @JsonProperty("U")
    private Long U;
    @JsonProperty("u")
    private Long u;
    @JsonProperty("pu")
    private Long pu;
    @JsonProperty("b")
    private List<List<String>> b;
    @JsonProperty("a")
    private List<List<String>> a;

    public static StreamEntity toEntity(StreamResponseDto dto){
        return new StreamEntity()
                .setEventType(dto.getEventType())
                .setEventTime(dto.getEventTime())
                .setTransactionTime(dto.getTransactionTime())
                .setSymbol(dto.getSymbol())
                .setPair(dto.getPair())
                .setFirstUpdateId(dto.getFirstUpdateId())
                .setFinalUpdateId(dto.getFinalUpdateId())
                .setFinalUpdateIdLastStream(dto.getFinalUpdateIdLastStream());
    }

    public String getEventType() {
        return e;
    }

    public Long getEventTime() {
        return E;
    }

    public Long getTransactionTime() {
        return T;
    }

    public String getSymbol() {
        return s;
    }

    public String getPair() {
        return ps;
    }

    public Long getFirstUpdateId() {
        return U;
    }

    public Long getFinalUpdateId() {
        return u;
    }

    public Long getFinalUpdateIdLastStream() {
        return pu;
    }

    public String getE() {
        return e;
    }

    public List<List<String>> getBidsBeUpdate() {
        return b;
    }

    public List<List<String>> getAsksBeUpdate() {
        return a;
    }

    public StreamResponseDto setE(Long e) {
        E = e;
        return this;
    }

    public Long getT() {
        return T;
    }

    public StreamResponseDto setT(Long t) {
        T = t;
        return this;
    }

    public String getS() {
        return s;
    }

    public StreamResponseDto setS(String s) {
        this.s = s;
        return this;
    }

    public String getPs() {
        return ps;
    }

    public StreamResponseDto setPs(String ps) {
        this.ps = ps;
        return this;
    }

    public Long getU() {
        return U;
    }

    public StreamResponseDto setU(Long u) {
        U = u;
        return this;
    }

    public Long getPu() {
        return pu;
    }

    public StreamResponseDto setPu(Long pu) {
        this.pu = pu;
        return this;
    }

    public List<List<String>> getB() {
        return b;
    }

    public StreamResponseDto setB(List<List<String>> b) {
        this.b = b;
        return this;
    }

    public List<List<String>> getA() {
        return a;
    }

    public StreamResponseDto setA(List<List<String>> a) {
        this.a = a;
        return this;
    }

    public StreamResponseDto setE(String e) {
        this.e = e;
        return this;
    }


    @Override
    public String toString() {
        return "SocketResponseDto{" +
                "e='" + e + '\'' +
                ", E=" + E +
                ", T=" + T +
                ", s='" + s + '\'' +
                ", ps='" + ps + '\'' +
                ", U=" + U +
                ", u=" + u +
                ", pu=" + pu +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
