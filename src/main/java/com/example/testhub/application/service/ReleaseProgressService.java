package com.example.testhub.application.service;

import com.example.testhub.application.dto.ReleaseProgressDto;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.release.ReleaseRepository;

import org.springframework.stereotype.Service;

@Service
public class ReleaseProgressService {

    private final ReleaseRepository releaseRepository;

    public ReleaseProgressService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public ReleaseProgressDto getProgress(ReleaseId releaseId) {

        Release release = releaseRepository
                .findById(releaseId)
                .orElseThrow(() -> new RuntimeException("Release not found"));

        int total = release.getTotalCases();
        int completed = release.getCompletedCases();
        int percentage = release.getProgressPercentage();

        return new ReleaseProgressDto(
                release.getId().getValue(),
                total,
                completed,
                percentage
        );
    }
}