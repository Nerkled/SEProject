package com.lucas2;

import java.io.File;
import java.util.List;

import com.lucas.*;

public class TestUser {
    
    // TODO 3: change the type of this variable to the name you're using for your
    // User <-> ComputeEngine API; also update the parameter passed to the constructor
    private final UserToComputeEngineImp coordinator;

    public TestUser(UserToComputeEngineImp coordinator) {
        this.coordinator = coordinator;
    }

    // TODO 4: Call the appropriate method(s) on the coordinator to get it to 
    // run the compute job specified by inputPath, outputPath, and delimiter
    public void run(String outputPath) {
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "testInputFile.test";

        FileInputConfig input = new FileInputConfig(inputPath);
        FileOutputConfig output = new FileOutputConfig(outputPath);
        Request request = new Request(input,output,delimiter);
        coordinator.compute(request);
    }

}
