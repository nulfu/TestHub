package com.example.testhub;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Release {

    private final ReleaseId id;
    private final ProjectId projectId;

    private final List<ReleaseCase> cases = new ArrayList<>();

    public void recordExecution(TestCaseVersionId versionId, Result result){

        ReleaseCase target = cases.stream()
            .filter(c -> c.isFor(versionId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("case not found"));

        target.recordExecution(result);
    }

    public double calculateProgressRatio(){

        long completed = cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();

        return (double) completed / cases.size();
    }
}