package com.lucas;
public interface Result {
    ResultStatus getResult();
    public static enum ResultStatus {
        SUCCESS, FAILURE
    }
}