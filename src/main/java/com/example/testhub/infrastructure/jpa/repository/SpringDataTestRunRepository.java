package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.infrastructure.jpa.entity.TestRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataTestRunRepository
        extends JpaRepository<TestRunEntity, UUID> {

    List<TestRunEntity> findByReleaseId(UUID releaseId);

    List<TestRunEntity> findByVersionId(UUID versionId);
}