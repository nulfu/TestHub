package com.example.testhub.controller;

import com.example.testhub.application.dto.ReleaseProgressDto;
import com.example.testhub.application.service.ReleaseProgressService;
import com.example.testhub.domain.release.ReleaseId;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/releases")
public class ReleaseController {

    private final ReleaseProgressService progressService;

    public ReleaseController(ReleaseProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/{releaseId}/progress")
    public ReleaseProgressDto getProgress(
            @PathVariable UUID releaseId
    ) {

        return progressService.getProgress(
                new ReleaseId(releaseId)
        );
    }
}