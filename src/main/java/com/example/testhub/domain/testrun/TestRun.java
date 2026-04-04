package com.example.testhub.domain.testrun;

import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.testcase.TestCaseVersionId;

import java.time.LocalDateTime;

public class TestRun {

    private final TestRunId id;
    private final ReleaseId releaseId;
    private final TestCaseVersionId versionId;
    private final Result result;
    private final LocalDateTime executedAt;

    public TestRun(
        ReleaseId releaseId,
        TestCaseVersionId versionId,
        Result result,
        LocalDateTime executedAt
    ){

        if(releaseId == null) throw new IllegalArgumentException();
        if(versionId == null) throw new IllegalArgumentException();
        if(result == null) throw new IllegalArgumentException();

        this.id = TestRunId.newId();
        this.releaseId = releaseId;
        this.versionId = versionId;
        this.result = result;
        this.executedAt = executedAt;
    }

    public ReleaseId getReleaseId(){
        return releaseId;
    }

    public TestCaseVersionId getVersionId(){
        return versionId;
    }

    public Result getResult(){
        return result;
    }

    public LocalDateTime getExecutedAt(){
        return executedAt;
    }
}