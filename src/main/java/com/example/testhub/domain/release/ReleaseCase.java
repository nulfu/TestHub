package com.example.testhub.domain.release;

import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.domain.testrun.Result;

public class ReleaseCase {

    private final ReleaseCaseId id;
    private final TestCaseVersionId versionId;

    private Result latestResult;

    public ReleaseCase(
        ReleaseCaseId id,
        TestCaseVersionId versionId,
        Result latestResult
    ) {
        this.id = id;
        this.versionId = versionId;
        this.latestResult = latestResult;
    }

    public ReleaseCaseId getId() {
        return id;
    }

    public TestCaseVersionId getVersionId() {
        return versionId;
    }

    public Result getLatestResult() {
        return latestResult;
    }

    public boolean isFor(TestCaseVersionId id) {
        return versionId.equals(id);
    }

    public void recordExecution(Result result) {

        if (result == null) {
            throw new IllegalArgumentException("result must not be null");
        }

        this.latestResult = result;
    }

    public boolean isCompleted() {
        return latestResult != null;
    }

}