package com.example.testhub.application.dto;

import java.util.UUID;

public class ReleaseProgressDto {

    private UUID releaseId;
    private int totalCases;
    private int passedCases;
    private int remainingCases;

    public ReleaseProgressDto(UUID releaseId,
                              int totalCases,
                              int passedCases,
                              int remainingCases) {
        this.releaseId = releaseId;
        this.totalCases = totalCases;
        this.passedCases = passedCases;
        this.remainingCases = remainingCases;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getPassedCases() {
        return passedCases;
    }

    public int getRemainingCases() {
        return remainingCases;
    }
}