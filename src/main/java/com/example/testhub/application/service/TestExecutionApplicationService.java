package com.example.testhub.application.service;

import com.example.testhub.domain.release.*;
import com.example.testhub.domain.testrun.*;
import com.example.testhub.domain.testcase.TestCaseVersionId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TestExecutionApplicationService {

    private final ReleaseRepository releaseRepository;
    private final TestRunRepository testRunRepository;

    public TestExecutionApplicationService(
        ReleaseRepository releaseRepository,
        TestRunRepository testRunRepository
    ){
        this.releaseRepository = releaseRepository;
        this.testRunRepository = testRunRepository;
    }

    @Transactional
    public void execute(
        ReleaseId releaseId,
        TestCaseVersionId versionId,
        Result result
    ){

        Release release = releaseRepository
            .findById(releaseId)
            .orElseThrow(() -> new RuntimeException("Release not found"));

        LocalDateTime now = LocalDateTime.now();

        TestRun run = new TestRun(
            releaseId,
            versionId,
            result,
            now
        );

        testRunRepository.save(run);

        release.recordExecution(
            versionId,
            result
        );

        releaseRepository.save(release);
    }
}