package com.example.testhub.infrastructure.jpa.mapper;

import com.example.testhub.domain.release.*;
import com.example.testhub.infrastructure.jpa.entity.*;

import org.springframework.stereotype.Component;

@Component
public class ReleaseMapper {

    public Release toDomain(ReleaseEntity entity){

        Release release = new Release(
            new ReleaseId(entity.getId()),
            new ProjectId(entity.getProjectId())
        );

        entity.getCases()
            .forEach(c -> release.addCase(
                new ReleaseCase(
                    new ReleaseCaseId(c.getId()),
                    new TestCaseVersionId(c.getVersionId()),
                    c.getLatestResult()
                )
            ));

        return release;
    }

    public ReleaseEntity toEntity(Release domain){

        ReleaseEntity entity = new ReleaseEntity(
            domain.getId().getValue(),
            domain.getProjectId().getValue()
        );

        domain.getCases()
            .forEach(c -> entity.addCase(
                new ReleaseCaseEntity(
                    c.getId().getValue(),
                    c.getVersionId().getValue(),
                    c.getLatestResult()
                )
            ));

        return entity;
    }
}