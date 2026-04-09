package com.example.testhub.controller;

import com.example.testhub.application.service.TestExecutionApplicationService;
import com.example.testhub.application.dto.ExecuteTestRequest;

import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.domain.testrun.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TestExecutionController {

    private final TestExecutionApplicationService service;

    public TestExecutionController(
        TestExecutionApplicationService service
    ) {
        this.service = service;
    }

    @PostMapping("/ui/test/execute")
    public String execute(ExecuteTestRequest request) {

        service.execute(
                new ReleaseId(request.getReleaseId()),
                new TestCaseVersionId(request.getTestCaseVersionId()),
                Result.valueOf(request.getResult())
        );

        return "redirect:/ui/dashboard?releaseId=" + request.getReleaseId();
    }
}