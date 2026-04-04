package com.example.testhub.infrastructure.jpa.entity;

import com.example.testhub.domain.testrun.Result;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "test_runs")
public class TestRunEntity {

    @Id
    private UUID id;

    @Column(name = "release_id", nullable = false)
    private UUID releaseId;

    @Column(name = "version_id", nullable = false)
    private UUID versionId;

    @Enumerated(EnumType.STRING)
    private Result result;

    @Column(name = "executed_at")
    private LocalDateTime executedAt;

    protected TestRunEntity() {}

    public TestRunEntity(
        UUID id,
        UUID releaseId,
        UUID versionId,
        Result result,
        LocalDateTime executedAt
    ) {
        this.id = id;
        this.releaseId = releaseId;
        this.versionId = versionId;
        this.result = result;
        this.executedAt = executedAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public UUID getVersionId() {
        return versionId;
    }

    public Result getResult() {
        return result;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }
}