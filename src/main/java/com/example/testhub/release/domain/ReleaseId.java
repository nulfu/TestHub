package com.example.testhub.release.domain;

import java.io.Serializable;
import java.util.Objects;

public class ReleaseId implements Serializable {

    private final Long value;

    public ReleaseId(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("ReleaseId cannot be null");
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReleaseId)) return false;
        ReleaseId that = (ReleaseId) o;
        return Objects.equals(value, that.value);
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
