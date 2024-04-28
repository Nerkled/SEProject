package com.lucas;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        StorageToComputeEngineAPI dataStorage = new DataStorageFiles();
        ComputeEngine engine = new LucasComputeEngine("localhost", 0);
        UserToComputeEngineAPI coordinator = new UserToComputeEngineComponent(dataStorage, engine,7);
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "com" + File.separatorChar + "lucas2" + File.separatorChar + "testInputFileLarge.test";
        String outputPath = "your_output_path_here";

        FileInputConfig input = new FileInputConfig(inputPath);
        FileOutputConfig output = new FileOutputConfig(outputPath);
        Request request = new Request(input, output, delimiter);
        coordinator.compute(request);
        //write the output of compute inv a print statement
        ComputeResult result = coordinator.compute(request);
        System.out.println(result.getStatus());
    }
}