package com.example.testhub.application.dto;

import java.util.List;

public class DashboardDto {

    private final ReleaseProgressDto progress;
    private final long passCount;
    private final long failCount;
    private final List<ReleaseCaseViewDto> cases;

    public DashboardDto(
            ReleaseProgressDto progress,
            long passCount,
            long failCount,
            List<ReleaseCaseViewDto> cases
    ) {
        this.progress = progress;
        this.passCount = passCount;
        this.failCount = failCount;
        this.cases = cases;
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