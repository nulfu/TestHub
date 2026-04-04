package com.example.testhub.domain.release;

import java.util.Objects;
import java.util.UUID;

public class ReleaseCaseId {

    private final UUID value;

    public ReleaseCaseId(UUID value){
        if(value == null){
            throw new IllegalArgumentException("ReleaseCaseId must not be null");
        }
        this.value = value;
    }

    public static ReleaseCaseId newId(){
        return new ReleaseCaseId(UUID.randomUUID());
    }

    public UUID getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof ReleaseCaseId)) return false;
        ReleaseCaseId that = (ReleaseCaseId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
}