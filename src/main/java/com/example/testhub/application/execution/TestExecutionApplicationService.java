package com.example.testhub.application.execution;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseRepository;
import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.domain.testrun.Result;
import com.example.testhub.domain.testrun.TestRun;
import com.example.testhub.domain.testrun.TestRunRepository;

@Service
public class TestExecutionApplicationService {

    private final ReleaseRepository releaseRepository;
    private final TestRunRepository testRunRepository;

    public TestExecutionApplicationService(
        ReleaseRepository releaseRepository,
        TestRunRepository testRunRepository
    ) {
        this.releaseRepository = releaseRepository;
        this.testRunRepository = testRunRepository;
    }

    @Transactional
    public void execute(
        ReleaseId releaseId,
        TestCaseVersionId versionId,
        Result result
    ) {

        Release release = releaseRepository.find(releaseId);

        release.updateCaseResult(versionId, result);

        TestRun run = new TestRun(
            releaseId,
            versionId,
            result,
            LocalDateTime.now()
        );

        testRunRepository.save(run);

        releaseRepository.save(release);
    }
    
}
