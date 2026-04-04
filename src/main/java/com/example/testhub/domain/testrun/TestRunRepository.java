package com.example.testhub.domain.testrun;

import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.testcase.TestCaseVersionId;

import java.util.List;

public interface TestRunRepository {

    void save(TestRun run);

    List<TestRun> findByRelease(ReleaseId releaseId);

    List<TestRun> findByVersion(TestCaseVersionId versionId);
}