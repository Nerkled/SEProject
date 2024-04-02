package com.lucas;

public interface ComputeResult {
    static ComputeResult SUCCESS = () -> Status.SUCCESS;
    static ComputeResult FAILURE = () -> Status.FAILURE;

    Status getStatus();
    static Status getStatus(ComputeResult result) {
        return result.getStatus();
    }

    public static enum Status {
        SUCCESS,
        FAILURE,
        NOT_AN_INTEGER;
    }
}
