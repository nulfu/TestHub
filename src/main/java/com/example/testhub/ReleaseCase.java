package com.example.testhub;

public class ReleaseCase {
    
    private final ReleaseCaseId id;
    private final TestCaseVersionId versionId;

    private Result latestResult;

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
        return latestResult == Result.PASS;
    }
}
