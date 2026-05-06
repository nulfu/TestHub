package com.example.testhub.application.dto;

import java.util.UUID;

public class ReleaseProgressDto {

    private UUID releaseId;
    private int totalCases;
    private int completedCases;
    private double progressPercentage;

    public ReleaseProgressDto(UUID releaseId,
                              int totalCases,
                              int completedCases,
                              double progressPercentage) {
        this.releaseId = releaseId;
        this.totalCases = totalCases;
        this.completedCases = completedCases;
        this.progressPercentage = progressPercentage;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getCompletedCases() {
        return completedCases;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }
}