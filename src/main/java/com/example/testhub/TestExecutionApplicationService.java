package com.example.testhub;

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

        TestRun run = new TestRun(
            releaseId,
            versionId,
            result,
            LocalDateTime.now()
        );

        testRunRepository.save(run);
        release.updateCaseResult(versionId, result);
        releaseRepository.save(release);
    }
    
}
