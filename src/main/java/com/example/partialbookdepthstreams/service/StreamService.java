package com.example.partialbookdepthstreams.service;

import com.example.partialbookdepthstreams.entity.StreamBidAskEntity;
import com.example.partialbookdepthstreams.entity.StreamEntity;
import com.example.partialbookdepthstreams.repository.StreamBidAskRepository;
import com.example.partialbookdepthstreams.repository.StreamRepository;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

    private final StreamRepository streamRepository;
    private final StreamBidAskRepository streamBidAskRepository;

    public StreamService(StreamRepository streamRepository, StreamBidAskRepository streamBidAskRepository) {
        this.streamRepository = streamRepository;
        this.streamBidAskRepository = streamBidAskRepository;
    }

    public StreamEntity save(StreamEntity streamEntity) {
        return streamRepository.save(streamEntity);
    }

    public StreamBidAskEntity save(StreamBidAskEntity streamBidAskEntity) {
        return streamBidAskRepository.save(streamBidAskEntity);
    }
}
