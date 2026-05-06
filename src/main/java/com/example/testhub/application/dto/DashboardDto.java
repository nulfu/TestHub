package com.example.testhub.application.dto;

import java.util.List;
import java.util.UUID;

public class DashboardDto {

    private UUID releaseId;

    private final ReleaseProgressDto progress;
    private final long passCount;
    private final long failCount;
    private final List<ReleaseCaseViewDto> cases;

    public DashboardDto(
            UUID releaseId,
            ReleaseProgressDto progress,
            long passCount,
            long failCount,
            List<ReleaseCaseViewDto> cases
    ) {
        this.releaseId = releaseId;
        this.progress = progress;
        this.passCount = passCount;
        this.failCount = failCount;
        this.cases = cases;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public ReleaseProgressDto getProgress() {
        return progress;
    }

    public long getPassCount() {
        return passCount;
    }

    public long getFailCount() {
        return failCount;
    }

    public List<ReleaseCaseViewDto> getCases() {
        return cases;
    }
}