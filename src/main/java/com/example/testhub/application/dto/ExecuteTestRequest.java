package com.example.testhub.application.dto;

import java.util.UUID;

public class ExecuteTestRequest {

    private UUID releaseId;
    private UUID testCaseVersionId;
    private String result;

    public ExecuteTestRequest() {
    }

    public ExecuteTestRequest(UUID releaseId, UUID testCaseVersionId, String result) {
        this.releaseId = releaseId;
        this.testCaseVersionId = testCaseVersionId;
        this.result = result;
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
}