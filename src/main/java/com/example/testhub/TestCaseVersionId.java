package com.example.testhub.domain;

import java.util.Objects;
import java.util.UUID;

public class TestCaseVersionId {
    
    private final UUID value;

    public TestCaseVersionId(UUID value) {

        if (value == null) {
            throw new IllegalArgumentException("versionId is null");
        }

        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestCaseVetsionId)) return false;
        TestCaseVersionId that = (TestCaseVersionId) o;
        return value.equals(that.value);
    }
}
