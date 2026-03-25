package com.example.testhub;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.testhub.domain.repository.ReleaseRepository;
import com.example.testhub.domain.repository.TestRunRepository;

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

        release.recordExecution(
            versionId,
            result,
            LocalDateTime.now()
        );

        releaseRepository.save(release);
    }
    
}
