package com.example.testhub.domain.testcase;

import com.example.testhub.domain.project.ProjectId;

import java.util.List;
import java.util.Optional;

public interface TestCaseRepository {

    void save(TestCase testCase);

    Optional<TestCase> findById(TestCaseId id);

    List<TestCase> findByProjectId(ProjectId projectId);

    List<TestCase> findByProject(ProjectId projectId);

    void delete(TestCaseId id);
}