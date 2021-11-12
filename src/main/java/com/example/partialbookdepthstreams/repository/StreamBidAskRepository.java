package com.example.partialbookdepthstreams.repository;

import com.example.partialbookdepthstreams.entity.StreamBidAskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamBidAskRepository extends JpaRepository<StreamBidAskEntity, Long> {
}
