package com.example.testhub.infrastructure.mapper;

import com.example.testhub.domain.*;
import com.example.testhub.infrastructure.jpa.entity.*;

import java.util.UUID;
import java.util.stream.Collectors;

public class ReleaseMapper {

    public static Release toDomain(ReleaseEntity entity) {

        Release release = new Release(
            new ReleaseId(entity.getId()),
            new ProjectId(entity.getProjectId())
        );

        entity.getCases().forEach(c -> {

            ReleaseCase rc = new ReleaseCase(
                new ReleaseCaseId(c.getId()),
                new TestCaseVersionId(c.getVersionId()),
                c.getLatestResult()
            );

            release.addCase(rc);

        });

        return release;
    }

    public static ReleaseEntity toEntity(Release domain) {

        ReleaseEntity entity =
            new ReleaseEntity(
                domain.getId().getValue(),
                domain.getProjectId().getValue()
            );

        domain.getCases().forEach(c -> {

            ReleaseCaseEntity caseEntity =
                new ReleaseCaseEntity(
                    c.getId().getValue(),
                    c.getVersionId().getValue(),
                    c.getLatestResult()
                );

            entity.addCase(caseEntity);
        });

        return entity;
    }
}
