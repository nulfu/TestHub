package com.example.testhub.domain.testrun;

public enum Result {

    PASS,
    FAIL,
    BLOCKED,
    NOT_EXECUTED;

    public boolean isPass() {
        return this == PASS;
    }
    
    public boolean isFail() {
        return this == FAIL;
    }
}
