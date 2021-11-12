package com.example.partialbookdepthstreams.service;

import com.example.partialbookdepthstreams.config.ApplicationConfiguration;
import com.example.partialbookdepthstreams.dto.DepthResponseDto;
import com.example.partialbookdepthstreams.dto.StreamResponseDto;
import com.example.partialbookdepthstreams.entity.StreamBidAskEntity;
import com.example.partialbookdepthstreams.entity.StreamEntity;
import com.example.partialbookdepthstreams.service.restclient.RestClient;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepthService {

    private final RestClient restClient;
    private final StreamService streamService;

    public DepthService(RestClient restClient, StreamService streamService) {
        this.restClient = restClient;
        this.streamService = streamService;
    }

    public void validationAndSave(StreamResponseDto streamResponseDto) {
        DepthResponseDto depth = getDepth();
        if (depth.getLastUpdateId() <= streamResponseDto.getFirstUpdateId()
                && streamResponseDto.getFinalUpdateId() >= depth.getLastUpdateId()) {
            StreamBidAskEntity streamBidAskEntity = new StreamBidAskEntity();
            streamBidAskEntity.setAsks(removeQuantityZero(streamResponseDto.getAsksBeUpdate()));
            streamBidAskEntity.setBids(removeQuantityZero(streamResponseDto.getBidsBeUpdate()));
            StreamEntity streamEntity = StreamResponseDto.toEntity(streamResponseDto);
            StreamEntity save = streamService.save(streamEntity);
            streamBidAskEntity.setStreamEntity(save);
            streamService.save(streamBidAskEntity);
        }
    }

    private String removeQuantityZero(List<List<String>> list) {
        List<List<String>> collect = list.stream()
                .filter(data -> !data.get(1).equalsIgnoreCase("0"))
                .collect(Collectors.toList());
        return new Gson().toJson(collect);
    }

    public DepthResponseDto getDepth() {
        return restClient.getForObject(ApplicationConfiguration.getBinanceDepthUrl(), DepthResponseDto.class);
    }
}
