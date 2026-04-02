package com.example.testhub.infrastructure.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "test_runs")
public class TestRunEntity {

    @Id
    private UUID id;

    @Column(name = "release_id")
    private UUID releaseId;

    @Column(name = "version_id")
    private UUID versionId;

    @Column(name = "result")
    private String result;

    @Column(name = "executed_at")
    private LocalDateTime executedAt;

    protected TestRunEntity(){}

    public TestRunEntity(
        UUID id,
        UUID releaseId,
        UUID versionId,
        String result,
        LocalDateTime executedAt
    ){
        this.id = id;
        this.releaseId = releaseId;
        this.versionId = versionId;
        this.result = result;
        this.executedAt = executedAt;
    }

}