package com.lucas;

import java.util.Arrays;
import java.util.List;
@SuppressWarnings("unused")
public class UserToComputeEngineImp implements UserToComputeEngineAPI {
    private final StorageToComputeEngineAPI dataStore;
    private final ComputeEngine computeEngine;

    public UserToComputeEngineImp(StorageToComputeEngineAPI dataStore, ComputeEngine computeEngine) {
        this.dataStore = dataStore;
        this.computeEngine = computeEngine;
    }

    //@Override
    //Massive Change here
    public ComputeResult compute(ComputeRequest request) {
        return ComputeResult.FAILURE;
    }
}