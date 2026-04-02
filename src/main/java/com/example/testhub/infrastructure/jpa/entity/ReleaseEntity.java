package com.example.testhub.infrastructure.jpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "releases")
public class ReleaseEntity {

    @Id
    private UUID id;

    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    @OneToMany(
        mappedBy = "release",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private List<ReleaseCaseEntity> cases = new ArrayList<>();

    protected ReleaseEntity() {}

    public ReleaseEntity(UUID id, UUID projectId) {
        this.id = id;
        this.projectId = projectId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public List<ReleaseCaseEntity> getCases() {
        return cases;
    }

    public void addCase(ReleaseCaseEntity entity) {
        cases.add(entity);
        entity.setRelease(this);
    }

    public void clearCases() {
        cases.clear();
    }
}
