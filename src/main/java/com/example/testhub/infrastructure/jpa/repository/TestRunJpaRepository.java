package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.infrastructure.jpa.entity.TestRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestRunJpaRepository
        extends JpaRepository<TestRunEntity, UUID> {
}
