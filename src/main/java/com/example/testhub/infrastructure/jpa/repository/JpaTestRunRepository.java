package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.domain.testrun.*;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.infrastructure.jpa.mapper.*;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaTestRunRepository implements TestRunRepository {

    private final SpringDataTestRunRepository repository;
    private final TestRunMapper mapper;

    public JpaTestRunRepository(
        SpringDataTestRunRepository repository,
        TestRunMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(TestRun run) {
        repository.save(
            mapper.toEntity(run)
        );
    }

    @Override
    public List<TestRun> findByRelease(ReleaseId releaseId) {

        return repository
            .findByReleaseId(releaseId.getValue())
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<TestRun> findByVersion(TestCaseVersionId versionId) {

        return repository
            .findByVersionId(versionId.getValue())
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }
}