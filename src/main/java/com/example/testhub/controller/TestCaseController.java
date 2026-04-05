package com.example.testhub.controller;

import com.example.testhub.application.service.TestCaseManagementService;
import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.TestCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    private final TestCaseManagementService testCaseService;

    public TestCaseController(
            TestCaseManagementService testCaseService
    ) {
        this.testCaseService = testCaseService;
    }

    @PostMapping
    public void createTestCase(
            @RequestBody TestCase testCase
    ) {
        testCaseService.createTestCase(testCase);
    }

    @GetMapping("/project/{projectId}")
    public List<TestCase> findByProject(
            @PathVariable UUID projectId
    ) {

        return testCaseService.findByProject(
                new ProjectId(projectId)
        );
    }
}