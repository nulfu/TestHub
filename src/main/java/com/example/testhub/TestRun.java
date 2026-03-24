package com.example.testhub;

import java.time.LocalDateTime;
import java.util.Objects;

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
    ) {
        this.id = TestRunId.newId();
        this.releaseId = releaseId;
        this.versionId = versionId;
        this.result = result;
        this.executedAt = executedAt;
        Objects.requireNonNull(releaseId);
        Objects.requireNonNull(versionId);
        Objects.requireNonNull(result);
        Objects.requireNonNull(executedAt);
    }
}
