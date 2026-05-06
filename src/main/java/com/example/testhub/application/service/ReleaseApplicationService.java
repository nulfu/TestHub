package com.example.testhub.application.service;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.release.ReleaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ReleaseApplicationService {

    private final ReleaseRepository releaseRepository;

    public ReleaseApplicationService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Transactional
    public UUID create(UUID projectId, String name) {

        if (projectId == null) {
            throw new IllegalArgumentException("projectId must not be null");
        }

        if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("name must not be empty");
        }

        Release release = new Release(
            ReleaseId.newId(),
            new ProjectId(projectId),
            name
        );

        releaseRepository.save(release);

        return release.getId().getValue();
    }
}