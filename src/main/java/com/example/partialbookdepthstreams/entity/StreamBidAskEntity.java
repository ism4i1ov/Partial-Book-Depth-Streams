package com.example.partialbookdepthstreams.entity;

import javax.persistence.*;

@Entity
@Table(name = "stream_bids_asks")
public class StreamBidAskEntity extends BasedEntity {

    @OneToOne
    @JoinColumn(name = "stream_id", referencedColumnName = "id")
    private StreamEntity streamEntity;

    @Column(name = "bids")
    private String bids;

    @Column(name = "asks")
    private String asks;

    public StreamEntity getStreamEntity() {
        return streamEntity;
    }

    public StreamBidAskEntity setStreamEntity(StreamEntity streamEntity) {
        this.streamEntity = streamEntity;
        return this;
    }

    public String getBids() {
        return bids;
    }

    public StreamBidAskEntity setBids(String bids) {
        this.bids = bids;
        return this;
    }

    public String getAsks() {
        return asks;
    }

    public StreamBidAskEntity setAsks(String asks) {
        this.asks = asks;
        return this;
    }
}
