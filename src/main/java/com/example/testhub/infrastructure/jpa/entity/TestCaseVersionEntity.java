package com.example.testhub.infrastructure.jpa.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "test_case_versions")
public class TestCaseVersionEntity {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_case_id")
    private TestCaseEntity testCase;

    @Column(nullable = false)
    private int version;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String steps;

    @Column(length = 2000)
    private String expectedResult;

    protected TestCaseVersionEntity(){}

    public TestCaseVersionEntity(
            UUID id,
            int version,
            String title,
            String steps,
            String expectedResult
    ) {
        this.id = id;
        this.version = version;
        this.title = title;
        this.steps = steps;
        this.expectedResult = expectedResult;
    }

    public UUID getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getTitle() {
        return title;
    }

    public String getSteps() {
        return steps;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public TestCaseEntity getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCaseEntity testCase) {
        this.testCase = testCase;
    }
}