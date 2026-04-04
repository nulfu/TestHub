package com.example.testhub.domain.project;

import java.util.Objects;
import java.util.UUID;

public class ProjectId {

    private final UUID value;

    public ProjectId(UUID value) {
        if (value == null) {
            throw new IllegalArgumentException("ProjectId must not be null");
        }
        this.value = value;
    }

    public static ProjectId newId() {
        return new ProjectId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectId projectId = (ProjectId) o;
        return value.equals(projectId.value);
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