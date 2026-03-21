package com.example.testhub;

import java.time.LocalDateTime;

public class Release {
    private final ReleaseId id;
    private final ProjectId projectId;
    private final TargetVersions targets;

    private final List<TestRun> runs = new ArrayList<>();

    public void addTestRun(TestCaseVersionId versionId, Result result){

        if (!targets.contains(versionId)){
            throw new IllegalArgumentException("Target外");
        }

        TestRun run = new TestRun(
            versionId,
            result,
            LocalDateTime.now()
        );

        runs.add(run);
    }

    public Optional<TestRun> getLatestRun(TestCaseVersionId versionId) {
        return runs.stream()
            .filter(r -> r.isFor(versionId))
            .max(Comparator.comparing(TestRun::getExecutedAt));
    }

    public double calculateProgress(){

        long completed = targets.getAll().stream()
            .filter(v -> isCompleted(v))
            .count();

        return (double) completed / targets.size();
    }

    
}
