package com.example.testhub.domain.testcase;


public class TestCaseVersion {

    private final TestCaseVersionId id;
    private final int version;
    private String title;
    private String steps;
    private String expectedResult;

    public TestCaseVersion(
            TestCaseVersionId id,
            int version,
            String title,
            String steps,
            String expectedResult
    ) {

        if (id == null) {
            throw new IllegalArgumentException("versionId must not be null");
        }

        this.id = id;
        this.version = version;
        this.title = title;
        this.steps = steps;
        this.expectedResult = expectedResult;
    }

    public TestCaseVersionId getId() {
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
}