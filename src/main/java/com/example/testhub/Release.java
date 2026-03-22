package com.example.testhub;

import java.time.LocalDateTime;

public class Release {

    private final ReleaseId id;
    private final ProjectId projectId;

    private final List<ReleaseCase> cases = new ArrayList<>();

    public void updateCaseResult(TestCaseVersionId versionId, Result result){

        ReleaseCase target = cases.stream()
            .filter(c -> c.isFor(versionId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("case not found"));

        target.updateResult(result);
    }

    public double calculateProgress(){

        long completed = cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();

        return (double) completed / cases.size();
    }
}