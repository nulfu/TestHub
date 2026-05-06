package com.example.testhub.controller;

import com.example.testhub.application.dto.ReleaseProgressDto;
import com.example.testhub.application.dto.CreateReleaseRequest;
import com.example.testhub.application.service.ReleaseApplicationService;
import com.example.testhub.application.service.ReleaseProgressService;
import com.example.testhub.domain.release.ReleaseId;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/releases")
public class ReleaseController {

    private final ReleaseProgressService progressService;
    private final ReleaseApplicationService releaseService;

    public ReleaseController(
        ReleaseProgressService progressService,
        ReleaseApplicationService releaseService
    ) {
        this.progressService = progressService;
        this.releaseService = releaseService;
    }

    @GetMapping("/{releaseId}/progress")
    public ReleaseProgressDto getProgress(
            @PathVariable UUID releaseId
    ) {

        return progressService.getProgress(
                new ReleaseId(releaseId)
        );
    }

    @PostMapping
    public UUID createRelease(@RequestBody CreateReleaseRequest request) {

        return releaseService.create(
            request.getProjectId(),
            request.getName()
        );
    }
}