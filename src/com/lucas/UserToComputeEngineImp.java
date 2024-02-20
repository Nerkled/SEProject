//Justin Feinman
package com.lucas;

public class UserToComputeEngineImp implements UserToComputeEngineAPI {

    private final StorageToComputeEngineAPI dataStore;
    private final ComputeEngine computeEngine;

    public UserToComputeEngineImp(StorageToComputeEngineAPI datastore, ComputeEngine computeengine) {
        this.dataStore = datastore;
        this.computeEngine = computeengine;
    }

    //@Override
    public ComputeResult compute(ComputeRequest request) {
        return ComputeResult.FAILURE;
    }
}
