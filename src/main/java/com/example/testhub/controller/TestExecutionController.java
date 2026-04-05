package com.example.testhub.controller;

import com.example.testhub.application.dto.ExecuteTestRequest;
import com.example.testhub.application.dto.TestRunDto;
import com.example.testhub.application.service.TestExecutionApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-executions")
public class TestExecutionController {

    private final TestExecutionApplicationService executionService;

    public TestExecutionController(
            TestExecutionApplicationService executionService
    ) {
        this.executionService = executionService;
    }

    @PostMapping
    public TestRunDto executeTest(
            @RequestBody ExecuteTestRequest request
    ) {

        return executionService.execute(request);
    }
}