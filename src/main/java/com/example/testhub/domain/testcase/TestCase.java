package com.example.testhub.domain.testcase;

import com.example.testhub.domain.project.ProjectId;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private final TestCaseId id;
    private final ProjectId projectId;

    private final List<TestCaseVersion> versions = new ArrayList<>();

    public TestCase(TestCaseId id, ProjectId projectId) {

        if (id == null) {
            throw new IllegalArgumentException("testCaseId must not be null");
        }

        if (projectId == null) {
            throw new IllegalArgumentException("projectId must not be null");
        }

        this.id = id;
        this.projectId = projectId;
    }

    public TestCaseId getId() {
        return id;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public List<TestCaseVersion> getVersions() {
        return versions;
    }

    public TestCaseVersion latestVersion() {
        if (versions.isEmpty()) {
            throw new IllegalStateException("No version exists");
        }
        return versions.get(versions.size() - 1);
    }

    public void addVersion(TestCaseVersion version) {
        versions.add(version);
    }
}