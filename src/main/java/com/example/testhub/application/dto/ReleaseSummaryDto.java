package com.example.testhub.application.dto;

import java.util.UUID;

public class ReleaseSummaryDto {

    private final UUID releaseId;
    private final String name;
    private final int progressPercentage;

    public ReleaseSummaryDto(
        UUID releaseId,
        String name,
        int progressPercentage
    ) {
        this.releaseId = releaseId;
        this.name = name;
        this.progressPercentage = progressPercentage;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public String getName() {
        return name;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }
}