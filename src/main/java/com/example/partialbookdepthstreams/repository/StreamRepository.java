package com.example.partialbookdepthstreams.repository;

import com.example.partialbookdepthstreams.entity.StreamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends JpaRepository<StreamEntity, Long> {
}
