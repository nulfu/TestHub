package com.example.testhub.controller;

import com.example.testhub.application.service.ReleaseQueryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReleasePageController {

    private final ReleaseQueryService releaseQueryService;

    public ReleasePageController(
        ReleaseQueryService releaseQueryService
    ) {
        this.releaseQueryService = releaseQueryService;
    }

    @GetMapping("/ui/releases")
    public String releases(Model model){

        model.addAttribute(
            "releases",
            releaseQueryService.findAllSummaries()
        );

        return "releases";
    }
}