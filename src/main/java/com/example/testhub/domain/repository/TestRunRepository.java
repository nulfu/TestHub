package com.example.testhub.domain.repository;

import com.example.testhub.TestRun;

public interface TestRunRepository {

    void save(TestRun testrun);

    List<TestRun> findByReleaseId(ReleaseId releaseId);
    
}
