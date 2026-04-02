package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.infrastructure.jpa.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReleaseJpaRepository
        extends JpaRepository<ReleaseEntity, UUID> {
}