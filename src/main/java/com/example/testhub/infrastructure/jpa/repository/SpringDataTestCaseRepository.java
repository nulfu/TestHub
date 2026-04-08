package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.infrastructure.jpa.entity.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataTestCaseRepository
        extends JpaRepository<TestCaseEntity, UUID> {

    List<TestCaseEntity> findByProjectId(UUID projectId);
}