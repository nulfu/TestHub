package com.example.testhub.domain.testcase;

import java.util.Objects;
import java.util.UUID;

public class TestCaseId {

    private final UUID value;

    public TestCaseId(UUID value) {

        if (value == null) {
            throw new IllegalArgumentException("TestCaseId must not be null");
        }

        this.value = value;
    }

    public static TestCaseId newId() {
        return new TestCaseId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestCaseId)) return false;
        TestCaseId that = (TestCaseId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}