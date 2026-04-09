package com.example.testhub.controller;

import com.example.testhub.application.service.ReleaseProgressService;
import com.example.testhub.domain.release.ReleaseId;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class DashboardController {

    private final ReleaseProgressService progressService;

    public DashboardController(ReleaseProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/ui/dashboard")
    public String dashboard(
        @RequestParam UUID releaseId,
        Model model
    ) {

        model.addAttribute(
            "progress",
            progressService.getProgress(new ReleaseId(releaseId))
        );

        return "dashboard";
    }
}