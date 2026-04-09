package com.example.testhub.controller;

import com.example.testhub.application.service.TestExecutionApplicationService;
import com.example.testhub.application.dto.ExecuteTestRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/test-execution")
public class TestExecutionPageController {

    private final TestExecutionApplicationService service;

    public TestExecutionPageController(
        TestExecutionApplicationService service
    ){
        this.service = service;
    }

    @GetMapping
    public String page(){
        return "test-execution";
    }

    @PostMapping
    public String execute(
        @RequestParam UUID releaseId,
        @RequestParam UUID versionId,
        @RequestParam String result
    ){

        ExecuteTestRequest request = new ExecuteTestRequest();
        request.setReleaseId(releaseId);
        request.setVersionId(versionId);
        request.setResult(result);

        service.execute(request);

        return "redirect:/ui/test-execution";
    }
}