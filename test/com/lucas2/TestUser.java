package com.lucas2;

import java.io.File;
import java.util.List;

import com.lucas.ComputeRequest;
import com.lucas.ComputeResult;
import com.lucas.DataStorageFiles;
import com.lucas.FileInputConfig;
import com.lucas.FileOutputConfig;
import com.lucas.InputConfig;
import com.lucas.OutputConfig;
import com.lucas.UserToComputeEngineAPI;

public class TestUser {
    
    // TODO 3: change the type of this variable to the name you're using for your
    // User <-> ComputeEngine API; also update the parameter passed to the constructor
    private final UserToComputeEngineAPI coordinator;

    public TestUser(UserToComputeEngineAPI coordinator) {
        this.coordinator = coordinator;
    }

    // TODO 4: Call the appropriate method(s) on the coordinator to get it to 
    // run the compute job specified by inputPath, outputPath, and delimiter
    public void run(String outputPath) {
        char delimiter = ';';
        InputConfig inputConfig = new FileInputConfig("testInputFile.TEST");
        OutputConfig outputConfig = new FileOutputConfig(outputPath);

        DataStorageFiles dataStorage = new DataStorageFiles(outputPath);

        // Read the input data
        List<Integer> inputData = InputConfig.visitInputConfig(inputConfig, new InputConfig.InputConfigVisitor<List<Integer>>() {
            @Override
            public List<Integer> visitFile(FileInputConfig fileInputConfig) {
                return dataStorage.read(fileInputConfig);
            }
        });

        // Create a ComputeRequest object
        ComputeRequest request = new ComputeRequest() {
            @Override
            public InputConfig getInputConfig() {
                return inputConfig;
            }
    
            @Override
            public OutputConfig getOutputConfig() {
                return outputConfig;
            }
    
            @Override
            public char getDelimiter() {
                return delimiter;
            }
        };

        // Call the compute method on the coordinator
        ComputeResult result = coordinator.compute(request);

        // Write the result
        OutputConfig.visitOutputConfig(outputConfig, new OutputConfig.OutputConfigVisitor() {
            @Override
            public void visitFile(FileOutputConfig fileOutputConfig) {
                dataStorage.write(fileOutputConfig, result.toString());
            }
        });
    }

}
