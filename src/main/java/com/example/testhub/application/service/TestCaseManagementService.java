package com.example.testhub.application.service;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.TestCase;
import com.example.testhub.domain.testcase.TestCaseId;
import com.example.testhub.domain.testcase.TestCaseRepository;

import java.util.UUID;

public class TestCaseManagementService {

    private final TestCaseRepository testCaseRepository;

    public TestCaseManagementService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    public UUID createTestCase(UUID projectId) {

        TestCase testCase = new TestCase(
                new TestCaseId(),
                new ProjectId(projectId)
        );

        testCaseRepository.save(testCase);

        return UUID.fromString(testCase.getId().getValue());
    }
}