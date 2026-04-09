package com.example.testhub.application.dto;

import java.util.UUID;

public class CreateTestCaseRequest {

    private UUID projectId;
    private String title;

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}