package com.example.testhub.application.dto;

import java.util.UUID;

public class CreateReleaseRequest {

    private UUID projectId;
    private String name;

    public UUID getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }
}