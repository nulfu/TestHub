package com.example.testhub.domain.release;

import java.util.Objects;
import java.util.UUID;

public class ReleaseId {

    private final UUID value;

    public ReleaseId(UUID value){
        if(value == null){
            throw new IllegalArgumentException("ReleaseId must not be null");
        }
        this.value = value;
    }

    public static ReleaseId newId(){
        return new ReleaseId(UUID.randomUUID());
    }

    public UUID getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof ReleaseId)) return false;
        ReleaseId that = (ReleaseId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
}