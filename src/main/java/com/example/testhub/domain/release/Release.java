package com.example.testhub.domain.release;

import java.util.ArrayList;
import java.util.List;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.domain.testrun.Result;

public class Release {

    private final ReleaseId id;
    private final ProjectId projectId;
    private final String name;

    private final List<ReleaseCase> cases = new ArrayList<>();

    public Release(
        ReleaseId id,
        ProjectId projectId,
        String name
    ) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
    }

    public ReleaseId getId() {
        return id;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public List<ReleaseCase> getCases() {
        return cases;
    }

    public void addCase(ReleaseCase releaseCase) {
        cases.add(releaseCase);
    }

    public int getTotalCases() {
        return cases.size();
    }

    public int getCompletedCases() {

        return (int) cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();
    }

    public int getProgressPercentage() {

        if (cases.isEmpty()) {
            return 0;
        }

        return (getCompletedCases() * 100) / cases.size();
    }

    public void recordExecution(
        TestCaseVersionId versionId,
        Result result
    ) {

        for (ReleaseCase c : cases) {

            if (c.isFor(versionId)) {
                c.recordExecution(result);
                return;
            }

        }

        throw new IllegalArgumentException(
            "TestCaseVersion not found in release"
        );
    }
}