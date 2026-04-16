package com.example.testhub.infrastructure.jpa.mapper;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.*;
import com.example.testhub.infrastructure.jpa.entity.*;
import org.springframework.stereotype.Component;

@Component
public class TestCaseMapper {

    public TestCaseEntity toEntity(TestCase domain){

        TestCaseEntity entity = new TestCaseEntity(
                domain.getId().getValue(),
                domain.getProjectId().getValue(),
                domain.latestVersion().getTitle()
        );

        domain.getVersions().forEach(v -> {

            TestCaseVersionEntity ve =
                new TestCaseVersionEntity(
                        v.getId().getValue(),
                        v.getVersion(),
                        v.getTitle(),
                        v.getSteps(),
                        v.getExpectedResult()
                );

            entity.addVersion(ve);
        });

        return entity;
    }

    public TestCase toDomain(TestCaseEntity entity){

        TestCase testCase = new TestCase(
                new TestCaseId(entity.getId()),
                new ProjectId(entity.getProjectId())
        );

        entity.getVersions().forEach(v -> {

            testCase.addVersion(
                    new TestCaseVersion(
                            new TestCaseVersionId(v.getId()),
                            v.getVersion(),
                            v.getTitle(),
                            v.getSteps(),
                            v.getExpectedResult()
                    )
            );
        });

        return testCase;
    }
}