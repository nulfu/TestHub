package com.example.testhub.application.service;

import com.example.testhub.application.dto.DashboardDto;
import com.example.testhub.application.dto.ReleaseCaseViewDto;
import com.example.testhub.application.dto.ReleaseProgressDto;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.release.ReleaseRepository;
import com.example.testhub.domain.release.ReleaseCase;
import com.example.testhub.domain.testrun.Result;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final ReleaseRepository releaseRepository;

    public DashboardService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public DashboardDto getDashboard(ReleaseId releaseId) {

        Release release = releaseRepository
                .findById(releaseId)
                .orElseThrow(() -> new RuntimeException("Release not found"));

        // ===== Progress =====
        int total = release.getTotalCases();
        int completed = release.getCompletedCases();
        double ratio = release.getProgressRatio();
        int percentage = (int) (ratio * 100);

        ReleaseProgressDto progress = new ReleaseProgressDto(
                release.getId().getValue(),
                total,
                completed,
                percentage,
                ratio
        );

        // ===== Pass / Fail 集計 =====
        long passCount = release.getCases().stream()
                .filter(c -> c.getLatestResult() != null && c.getLatestResult().isPass())
                .count();

        long failCount = release.getCases().stream()
                .filter(c -> c.getLatestResult() != null && c.getLatestResult().isFail())
                .count();

        // ===== Case → DTO変換 =====
        List<ReleaseCaseViewDto> cases = release.getCases().stream()
                .map(this::toCaseDto)
                .toList();

        return new DashboardDto(
                release.getId().getValue(),
                progress,
                passCount,
                failCount,
                cases
        );
    }

    // ===== 変換ロジックを閉じ込める =====
    private ReleaseCaseViewDto toCaseDto(ReleaseCase c) {

        Result result = c.getLatestResult();

        String resultText = (result == null) ? "-" : result.name();
        String color = resolveColor(result);

        return new ReleaseCaseViewDto(
                c.getVersionId().getValue(),
                resultText,
                color
        );
    }

    private String resolveColor(Result result) {

        if (result == null) return "";

        return switch (result) {
            case PASS -> "green";
            case FAIL -> "red";
            case BLOCKED -> "orange";
            case NOT_EXECUTED -> "gray";
        };
    }
}