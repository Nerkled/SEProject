package com.lucas;


import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class UserToComputeEngineImp implements UserToComputeEngineAPI {
    private final StorageToComputeEngineAPI dataStore;
    private final ComputeEngine computeEngine;

    public UserToComputeEngineImp(StorageToComputeEngineAPI dataStore, ComputeEngine computeEngine) {
        this.dataStore = dataStore;
        this.computeEngine = computeEngine;
    }

    //@Override
    public ComputeResult compute(Request request) {
        //wire this to lucas compute engine
        //wire this to datastorage to write out to output path
        List<Integer> integers = dataStore.read(request.getInputConfig());
	    dataStore.write(request.getOutputConfig(),computeEngine.compute(integers));
    	return ComputeResult.SUCCESS;
    }
}