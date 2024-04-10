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
    //Massive Change here
    public ComputeResult compute(Request request) {
        //wire this to lucas compute engine
        //wire this to datastorage to write out to output path
        InputConfig inputPath = request.getInputConfig();
        char delimiter = request.getDelimiter();
        OutputConfig outputPath = request.getOutputConfig();
        List<Integer> inputData = readInputDataFromFile(inputPath);

        // Pass inputData and other necessary parameters to compute engine
        computeEngine.compute(inputData);

        // Write the output to the specified output path using data storage
        dataStore.write(outputPath,"Success");

        return ComputeResult.SUCCESS;
    }
    private List<Integer> readInputDataFromFile(InputConfig inputConfig) {
        List<Integer> inputData = new ArrayList<>();
        /*try {
            BufferedReader reader = new BufferedReader(new FileReader(inputConfig.getFileName()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line contains an integer
                inputData.add(Integer.parseInt(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return inputData;
    }
}