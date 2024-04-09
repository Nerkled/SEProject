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
    public ComputeResult compute(Request request) {
        //wire this to lucas compute engine
        //wire this to datastorage to write out to output path

        ComputeResult computeResult = computeEngine.compute(request);

        // Write the output to the specified output path using data storage
        String outputPath = request.getOutputPath();
        dataStore.writeOutput(computeResult, outputPath);
        return computeResult;
    }
}