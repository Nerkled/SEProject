package com.lucas;
import java.io.File;

/*
 *  Make a @test for benchmark test, include the old way
 * and the new way and maybe compare speed or cpu usage
 * document this in repo
 * 
 *
 * 
 */
public class Main {
    public static void main(String[] args) {
        StorageToComputeEngineAPI dataStorage = new DataStorageFiles();
        ComputeEngine engine = new LucasComputeEngine("localhost", 0);
        DataStorageFiles dataStorageFiles = new DataStorageFiles();
        LucasComputeEngine computeComponent = new LucasComputeEngine("localhost", 0);
        UserToComputeEngineAPI coordinator = new UserToComputeEngineComponent(dataStorageFiles, computeComponent,10);
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "com" + File.separatorChar + "lucas2" + File.separatorChar + "testInputFile.test";
        String outputPath = "LucasOutputLarge";

        FileInputConfig input = new FileInputConfig(inputPath);
        FileOutputConfig output = new FileOutputConfig(outputPath);
        Request request = new Request(input, output, delimiter);
        coordinator.compute(request);
        //write the output of compute inv a print statement
        ComputeResult result = coordinator.compute(request);
        System.out.println(result.getStatus());
    }
}