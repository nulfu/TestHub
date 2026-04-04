package com.example.testhub.infrastructure.jpa.mapper;

import com.example.testhub.domain.testrun.*;
import com.example.testhub.infrastructure.jpa.entity.*;

import org.springframework.stereotype.Component;

@Component
public class TestRunMapper {

    public TestRunEntity toEntity(TestRun run){

        return new TestRunEntity(
            run.getId().getValue(),
            run.getReleaseId().getValue(),
            run.getVersionId().getValue(),
            run.getResult(),
            run.getExecutedAt()
        );
    }
}