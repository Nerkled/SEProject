package com.lucas;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserToComputeEngineComponent implements UserToComputeEngineAPI {

    private final DataStorageFiles dataStorage;
    private final LucasComputeEngine computeComponent;
    private final ExecutorService threadPool; // thread pool for threading

    public UserToComputeEngineComponent(DataStorageFiles dataStorage, LucasComputeEngine computeComponent, int numberOfThreads) {
        this.dataStorage = dataStorage;
        this.computeComponent = computeComponent;
        this.threadPool = Executors.newFixedThreadPool(numberOfThreads);
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        try {

            InputConfig inputConfig = request.getInputConfig();
            OutputConfig outputConfig = request.getOutputConfig();
            List<Integer> inputIntegers = dataStorage.read(inputConfig);

            // hopefully this is now parallel
            for (Integer input : inputIntegers) {
                Callable<Void> task = () -> {
                    String result = computeComponent.compute(input);
                    Result storageResult = dataStorage.write(outputConfig, result);
                    if (storageResult.getResult() == Result.ResultStatus.SUCCESS) {
                        System.out.println("Computation and storage successful");
                    } else {
                        System.out.println("Computation or storage failed");
                    }
                    return null; // Return type is Void
                };
                threadPool.submit(task);
            }

            return ComputeResult.SUCCESS;

        } catch (Exception e) {
            return ComputeResult.FAILURE;
        }
    }

    // Method to shut down the thread pool
    public void shutdownThreadPool() {
        threadPool.shutdown();
    }
}
