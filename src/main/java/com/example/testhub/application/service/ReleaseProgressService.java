package com.example.testhub.application.service;

import com.example.testhub.application.dto.ReleaseProgressDto;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.release.ReleaseRepository;

import java.util.UUID;

public class ReleaseProgressService {

    private final ReleaseRepository releaseRepository;

    public ReleaseProgressService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public ReleaseProgressDto getProgress(UUID releaseId) {

        Release release = releaseRepository.findById(new ReleaseId(releaseId))
                .orElseThrow(() -> new IllegalArgumentException("Release not found"));

        int total = release.getCases().size();

        int passed = (int) release.getCases()
                .stream()
                .filter(c -> c.isCompleted())
                .count();

        int remaining = total - passed;

        return new ReleaseProgressDto(
                releaseId,
                total,
                passed,
                remaining
        );
    }
}