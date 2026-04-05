package com.example.testhub.infrastructure.jpa.mapper;

import com.example.testhub.domain.testcase.TestCaseVersionId;
import com.example.testhub.domain.testrun.*;
import com.example.testhub.infrastructure.jpa.entity.*;
import com.example.testhub.domain.release.ReleaseId;

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

    public TestRun toDomain(TestRunEntity entity){

        return new TestRun(
            new ReleaseId(entity.getReleaseId()),
            new TestCaseVersionId(entity.getVersionId()),
            entity.getResult(),
            entity.getExecutedAt()
        );
    }
}