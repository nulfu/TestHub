package com.example.testhub.infrastructure.jpa.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class ProjectEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    protected ProjectEntity(){}

    public ProjectEntity(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}