package com.lucas2;

import com.lucas.FileInputConfig;
import com.lucas.FileOutputConfig;
import com.lucas.Request;
import com.lucas.UserToComputeEngineAPI;
import com.lucas.UserToComputeEngineImp;
import java.io.File;
import java.util.List;


public class TestUser {
    
    // TODO 3: change the type of this variable to the name you're using for your
    // User <-> ComputeEngine API; also update the parameter passed to the constructor
    private final UserToComputeEngineAPI coordinator;

    public TestUser(UserToComputeEngineAPI coordinator2) {
        this.coordinator = coordinator2;
    }

    // TODO 4: Call the appropriate method(s) on the coordinator to get it to 
    // run the compute job specified by inputPath, outputPath, and delimiter
    public void run(String outputPath) {
        String delimiter = "\n";
        String inputPath = "test" + File.separatorChar + "com" + File.separatorChar + "lucas2" + File.separatorChar + "testInputFile.test";
        FileInputConfig input = new FileInputConfig(inputPath);
        FileOutputConfig output = new FileOutputConfig(outputPath);
        Request request = new Request(input,output,delimiter);
        coordinator.compute(request);
    }

}
