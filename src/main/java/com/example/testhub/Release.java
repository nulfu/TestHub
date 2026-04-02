package com.example.testhub;

import java.util.List;
import java.util.ArrayList;

public class Release {

    private final ReleaseId id;
    private final ProjectId projectId;

    private final List<ReleaseCase> cases = new ArrayList<>();

    public Release(
        ReleaseId id,
        ProjectId projectId
    ) {
        this.id = id;
        this.projectId = projectId;
    }

    public void recordExecution(
        TestCaseVersionId versionId,
        Result result
    ){

        ReleaseCase target = cases.stream()
            .filter(c -> c.isFor(versionId))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("Version not included in this release")
            );

        target.recordExecution(result);
    }

    public double calculateProgressRatio(){

        long completed = cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();

        return (double) completed / cases.size();
    }

    public void addCase(ReleaseCase c){
        cases.add(c);
    }

    public List<ReleaseCase> getCases(){
        return cases;
    }

    public ReleaseId getId(){
        return id;
    }

    public ProjectId getProjectId(){
        return projectId;
    }
}