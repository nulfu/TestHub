package com.example.testhub.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class TestRunDto {

    private UUID releaseId;
    private UUID testCaseVersionId;
    private String result;
    private LocalDateTime executedAt;

    public TestRunDto(UUID releaseId,
                      UUID testCaseVersionId,
                      String result,
                      LocalDateTime executedAt) {
        this.releaseId = releaseId;
        this.testCaseVersionId = testCaseVersionId;
        this.result = result;
        this.executedAt = executedAt;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public UUID getTestCaseVersionId() {
        return testCaseVersionId;
    }

    public String getResult() {
        return result;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }
}