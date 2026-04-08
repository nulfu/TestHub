package com.example.testhub.infrastructure.jpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "test_cases")
public class TestCaseEntity {

    @Id
    private UUID id;

    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    @Column(nullable = false)
    private String title;

    @OneToMany(
        mappedBy = "testCase",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TestCaseVersionEntity> versions = new ArrayList<>();

    protected TestCaseEntity(){}

    public TestCaseEntity(UUID id, UUID projectId, String title) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public List<TestCaseVersionEntity> getVersions() {
        return versions;
    }

    public void addVersion(TestCaseVersionEntity version) {
        versions.add(version);
        version.setTestCase(this);
    }

    public void clearVersions() {
        versions.clear();
    }
}