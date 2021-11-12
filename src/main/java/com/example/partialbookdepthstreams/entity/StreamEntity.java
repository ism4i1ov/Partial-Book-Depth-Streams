package com.example.partialbookdepthstreams.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TimeZone;

@Entity
@Table(name = "streams_log")
public class StreamEntity extends BasedEntity {

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "pair")
    private String pair;

    @Column(name = "first_update_id")
    private Long firstUpdateId;

    @Column(name = "final_update_id")
    private Long finalUpdateId;

    @Column(name = "final_update_id_last_stream")
    private Long finalUpdateIdLastStream;

    @OneToOne(mappedBy = "streamEntity")
    private StreamBidAskEntity streamBidAskEntity;

    public String getEventType() {
        return eventType;
    }

    public StreamEntity setEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public StreamEntity setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public StreamEntity setEventTime(Long eventTime) {
        this.eventTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(eventTime),
                TimeZone.getDefault().toZoneId());
        return this;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public StreamEntity setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
        return this;
    }

    public StreamEntity setTransactionTime(Long transactionTime) {
        this.transactionTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(transactionTime),
                TimeZone.getDefault().toZoneId());
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public StreamEntity setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getPair() {
        return pair;
    }

    public StreamEntity setPair(String pair) {
        this.pair = pair;
        return this;
    }

    public Long getFirstUpdateId() {
        return firstUpdateId;
    }

    public StreamEntity setFirstUpdateId(Long firstUpdateId) {
        this.firstUpdateId = firstUpdateId;
        return this;
    }

    public Long getFinalUpdateId() {
        return finalUpdateId;
    }

    public StreamEntity setFinalUpdateId(Long finalUpdateId) {
        this.finalUpdateId = finalUpdateId;
        return this;
    }

    public Long getFinalUpdateIdLastStream() {
        return finalUpdateIdLastStream;
    }

    public StreamEntity setFinalUpdateIdLastStream(Long finalUpdateIdLastStream) {
        this.finalUpdateIdLastStream = finalUpdateIdLastStream;
        return this;
    }

    public StreamBidAskEntity getStreamBidAskEntity() {
        return streamBidAskEntity;
    }

    public StreamEntity setStreamBidAskEntity(StreamBidAskEntity streamBidAskEntity) {
        this.streamBidAskEntity = streamBidAskEntity;
        return this;
    }
}
