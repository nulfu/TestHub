package com.example.testhub.application.service;

import com.example.testhub.application.dto.ReleaseSummaryDto;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseQueryService {

    private final ReleaseRepository releaseRepository;

    public ReleaseQueryService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public List<ReleaseSummaryDto> findAllSummaries() {

    List<Release> releases = releaseRepository.findAll();

    return releases.stream()
        .map(r -> {

            double ratio = r.getProgressRatio();
            int percentage = (int) (ratio * 100);

            return new ReleaseSummaryDto(
                r.getId().getValue(),
                r.getName(),
                percentage
            );
        })
        .toList();
    }
}