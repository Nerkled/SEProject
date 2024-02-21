package com.lucas;

public class UserToComputeEngineImp implements UserToComputeEngineAPI {

    private final StorageToComputeEngineAPI dataStore;
    private final ComputeEngine computeEngine;

    public UserToComputeEngineImp(StorageToComputeEngineAPI dataStore, ComputeEngine computeEngine) {
        this.dataStore = dataStore;
        this.computeEngine = computeEngine;
    }

    //@Override
    public ComputeResult compute(ComputeRequest request) {
        return ComputeResult.FAILURE;
    }
}
