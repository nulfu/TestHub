package com.example.testhub.application.dto;

import java.util.UUID;

public class ReleaseCaseViewDto {

    private final UUID versionId;
    private final String result;
    private final String color;

    public ReleaseCaseViewDto(UUID versionId, String result, String color) {
        this.versionId = versionId;
        this.result = result;
        this.color = color;
    }

    public UUID getVersionId() {
        return versionId;
    }

    public String getResult() {
        return result;
    }

    public String getColor() {
        return color;
    }
}