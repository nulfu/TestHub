package com.example.testhub.application.dto;

import java.util.UUID;

public class ReleaseProgressDto {

    private final UUID releaseId;
    private final int totalCases;
    private final int completedCases;

    // 表示用（0〜100）
    private final int percentage;

    // 計算用（0.0〜1.0）
    private final double ratio;

    public ReleaseProgressDto(
            UUID releaseId,
            int totalCases,
            int completedCases,
            int percentage,
            double ratio
    ) {
        this.releaseId = releaseId;
        this.totalCases = totalCases;
        this.completedCases = completedCases;
        this.percentage = percentage;
        this.ratio = ratio;
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

    public int getPercentage() {
        return percentage;
    }

    public double getRatio() {
        return ratio;
    }
}