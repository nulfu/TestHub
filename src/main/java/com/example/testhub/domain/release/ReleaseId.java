package com.example.testhub.domain.release;

import java.util.UUID;

public class ReleaseId {

    private final UUID value;

    public ReleaseId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }
}