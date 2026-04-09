package com.example.testhub.controller;

import com.example.testhub.application.service.ReleaseProgressService;
import com.example.testhub.application.dto.ReleaseProgressDto;
import com.example.testhub.domain.release.ReleaseId;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/dashboard")
public class DashboardPageController {

    private final ReleaseProgressService service;

    public DashboardPageController(
        ReleaseProgressService service
    ){
        this.service = service;
    }

    @GetMapping
    public String dashboard(
        @RequestParam UUID releaseId,
        Model model
    ){

        ReleaseProgressDto progress =
            service.getProgress(new ReleaseId(releaseId));

        model.addAttribute("progress", progress);

        return "dashboard";
    }
}