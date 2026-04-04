package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.domain.testrun.*;
import com.example.testhub.infrastructure.jpa.mapper.*;

import org.springframework.stereotype.Repository;

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
}