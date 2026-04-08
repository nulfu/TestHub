package com.example.testhub.application.service;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseManagementService {

    private final TestCaseRepository repository;

    public TestCaseManagementService(TestCaseRepository repository) {
        this.repository = repository;
    }

    public void createTestCase(TestCase testCase) {
        repository.save(testCase);
    }

    public List<TestCase> findByProject(ProjectId projectId) {
        return repository.findByProject(projectId);
    }
}