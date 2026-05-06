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
        if (id == null) throw new IllegalArgumentException("id is null");
        if (projectId == null) throw new IllegalArgumentException("projectId is null");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is empty");

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
        return new ArrayList<>(cases); // defensive copy
    }

    // ------------------------
    // ケース管理
    // ------------------------

    public void addCase(ReleaseCase releaseCase) {

        if (releaseCase == null) {
            throw new IllegalArgumentException("releaseCase is null");
        }

        // 重複防止（重要）
        boolean exists = cases.stream()
            .anyMatch(c -> c.isFor(releaseCase.getVersionId()));

        if (exists) {
            throw new IllegalArgumentException("Duplicate TestCaseVersion");
        }

        cases.add(releaseCase);
    }

    // ------------------------
    // 実行結果
    // ------------------------

    public void recordExecution(
        TestCaseVersionId versionId,
        Result result
    ) {

        if (versionId == null) {
            throw new IllegalArgumentException("versionId is null");
        }

        if (result == null) {
            throw new IllegalArgumentException("result is null");
        }

        ReleaseCase target = cases.stream()
            .filter(c -> c.isFor(versionId))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("TestCaseVersion not found in release")
            );

        target.recordExecution(result);
    }

    // ------------------------
    // 進捗
    // ------------------------

    public int getTotalCases() {
        return cases.size();
    }

    public int getCompletedCases() {
        return (int) cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();
    }

    /**
     * 進捗割合（0.0〜1.0）
     */
    public double getProgressRatio() {

        if (cases.isEmpty()) {
            return 0.0;
        }

        long completed = cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();

        return (double) completed / cases.size();
    }
}