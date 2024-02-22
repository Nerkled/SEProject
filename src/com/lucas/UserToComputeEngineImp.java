package com.lucas;
import com.lucas2.InMemoryImpStorageToComputeEngine;

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
        try {
            // Get the input data from the request
            List<Integer> inputData = request.getInputConfig().getIntegers();
    
            // Perform the computation
            String result = computeEngine.compute(inputData);

            // Update the OutputConfig with the result
            List<String> resultStrings = Arrays.asList(result.split(", "));
            request.getOutputConfig().getStrings().add(result);
    
            // If the computation was successful, return SUCCESS
            return ComputeResult.SUCCESS;
        } catch (Exception e) {
            // If there was an exception, return FAILURE
            return ComputeResult.FAILURE;
        }
    }
}