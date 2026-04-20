package com.example.testhub.controller;

import com.example.testhub.application.dto.ReleaseCaseViewDto;
import com.example.testhub.application.service.ReleaseProgressService;
import com.example.testhub.domain.release.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/dashboard")
public class DashboardController {

    private final ReleaseRepository releaseRepository;
    private final ReleaseProgressService progressService;

    public DashboardController(
        ReleaseRepository releaseRepository,
        ReleaseProgressService progressService
    ) {
        this.releaseRepository = releaseRepository;
        this.progressService = progressService;
    }

    @GetMapping
    public String dashboard(
        @RequestParam UUID releaseId,
        Model model
    ) {

        Release release = releaseRepository
            .findById(new ReleaseId(releaseId))
            .orElseThrow();

        var progress = progressService.getProgress(new ReleaseId(releaseId));

        long pass = release.getCases().stream()
            .filter(c -> c.getLatestResult() != null && c.getLatestResult().isPass())
            .count();

        long fail = release.getCases().stream()
            .filter(c -> c.getLatestResult() != null && c.getLatestResult().isFail())
            .count();
        var caseDtos = release.getCases().stream()
             .map(c -> {
                 var result = c.getLatestResult();

                 String resultStr = result != null ? result.name() : "NOT_EXECUTED";

                 String color = switch (resultStr) {
                     case "PASS" -> "green";
                     case "FAIL" -> "red";
                     case "BLOCKED" -> "orange";
                     default -> "gray";
                 };

                return new ReleaseCaseViewDto(
                   c.getVersionId().getValue(),
                   resultStr,
                   color
                 );
            })
            .toList();

        model.addAttribute("cases", caseDtos);
        model.addAttribute("releaseId", releaseId);
        model.addAttribute("progress", progress);
        model.addAttribute("passCount", pass);
        model.addAttribute("failCount", fail);

        return "dashboard";
    }
}