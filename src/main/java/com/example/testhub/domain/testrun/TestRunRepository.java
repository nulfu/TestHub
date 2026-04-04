package com.example.testhub.domain.testrun;

public interface TestRunRepository {

    void save(TestRun testrun);

    List<TestRun> findByReleaseId(ReleaseId releaseId);
    
}
