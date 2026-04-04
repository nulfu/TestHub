package com.example.testhub.domain.testrun;

public enum Result {

    PASS,
    FAIL;

    public boolean isPass() {
        return this == PASS;
    }
    
    public boolean isFail() {
        return this == FAIL;
    }
}
