package com.example.testhub.controller;

import com.example.testhub.application.dto.DashboardDto;
import com.example.testhub.application.service.DashboardService;
import com.example.testhub.domain.release.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public String dashboard(@RequestParam UUID releaseId, Model model) {

        DashboardDto dto = dashboardService.getDashboard(new ReleaseId(releaseId));

        model.addAttribute("dashboard", dto);

        return "dashboard";
    }
}