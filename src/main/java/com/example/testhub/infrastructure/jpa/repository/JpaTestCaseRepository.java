package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.*;

import com.example.testhub.infrastructure.jpa.entity.TestCaseEntity;
import com.example.testhub.infrastructure.jpa.mapper.TestCaseMapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaTestCaseRepository implements TestCaseRepository {

    private final SpringDataTestCaseRepository repository;
    private final TestCaseMapper mapper;

    public JpaTestCaseRepository(
        SpringDataTestCaseRepository repository,
        TestCaseMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(TestCase testCase) {

        TestCaseEntity entity = mapper.toEntity(testCase);

        repository.save(entity);
    }

    @Override
    public Optional<TestCase> findById(TestCaseId id) {

        return repository
            .findById(id.getValue())
            .map(mapper::toDomain);
    }

    @Override
    public List<TestCase> findByProject(ProjectId projectId) {

        return repository
            .findByProjectId(projectId.getValue())
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(TestCaseId id) {

        repository.deleteById(id.getValue());
    }
}