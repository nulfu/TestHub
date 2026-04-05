package com.example.testhub.domain.project;

public class Project {

    private final ProjectId id;
    private String name;

    public Project(ProjectId id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("projectId must not be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("project name must not be empty");
        }

        this.id = id;
        this.name = name;
    }

    public ProjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void rename(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("project name must not be empty");
        }
        this.name = name;
    }
}