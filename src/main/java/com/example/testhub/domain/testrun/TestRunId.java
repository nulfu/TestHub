package com.example.testhub.domain.testrun;

import java.util.Objects;
import java.util.UUID;

public class TestRunId {

    private final UUID value;

    private TestRunId(UUID value) {

        if (value == null) {
            throw new IllegalArgumentException("TestRunId cannot be null");
        }

        this.value = value;
    }

    public static TestRunId newId() {
        return new TestRunId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestRunId)) return false;
        TestRunId that = (TestRunId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}