package com.example.testhub.domain.release;

import com.example.testhub.release.domain.ReleaseId;

public class Release {


    private ReleaseId id;
    private String name;

    public Release(ReleaseId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ReleaseId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
