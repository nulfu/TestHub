package com.example.testhub.controller;

import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReleaseUiController {

    private final ReleaseRepository releaseRepository;

    public ReleaseUiController(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @GetMapping("/ui/releases")
    public String releases(Model model) {

        List<Release> releases = releaseRepository.findAll();

        model.addAttribute("releases", releases);

        return "releases";
    }
}