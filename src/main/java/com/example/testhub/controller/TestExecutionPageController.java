package com.example.testhub.controller;

import com.example.testhub.application.service.TestExecutionApplicationService;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.release.ReleaseRepository;
import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.domain.testrun.Result;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/test-execution")
public class TestExecutionPageController {

    private final TestExecutionApplicationService service;
    private final ReleaseRepository releaseRepository; // ← ★これ追加

    public TestExecutionPageController(
        TestExecutionApplicationService service,
        ReleaseRepository releaseRepository // ← ★DI追加
    ){
        this.service = service;
        this.releaseRepository = releaseRepository;
    }

    @GetMapping
    public String page(
        @RequestParam UUID releaseId,
        Model model
    ){

        Release release = releaseRepository
            .findById(new ReleaseId(releaseId))
            .orElseThrow();

        model.addAttribute("releaseId", releaseId);
        model.addAttribute("cases", release.getCases());

        return "test-execution";
    }

    @PostMapping
    public String execute(
        @RequestParam UUID releaseId,
        @RequestParam UUID versionId,
        @RequestParam String result
    ){

        service.execute(
            new ReleaseId(releaseId),
            new TestCaseVersionId(versionId),
            Result.valueOf(result)
        );

        return "redirect:/ui/test-execution?releaseId=" + releaseId;
    }
}