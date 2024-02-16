package com.lucas;
import com.lucas2.InMemoryImpStorageToComputeEngine;

@SuppressWarnings("unused")
public class LucasNumberCalculator implements LucasComputerAPI {

    private StorageToComputeEngineAPI storageToComputeEngineAPI;
    private InMemoryImpStorageToComputeEngine inMemoryImpStorageToComputeEngine;


    public LucasNumberCalculator(InMemoryImpStorageToComputeEngine inMemoryImpStorageToComputeEngine) {
        this.inMemoryImpStorageToComputeEngine = inMemoryImpStorageToComputeEngine;
    }

    // 1TODO: Add any additional methods or functionality as needed

    // 1: Initialize the API
    public void initialize() {
        //this.initialize(); // Note: This will cause a StackOverflowError
    }

    // 2: Get Write Data
    public void read(Input input) {
        //this.read(input); // Note: This will cause a StackOverflowError
    }

    // 3: Write Data
    public void write(Output output) {
        //this.write(output); // Note: This will cause a StackOverflowError
    }

    // 4: Pass Data through LucasComputingModule
    public void computeLucas(Input input) {
        //this.computeLucas(input); // Note: This will cause a StackOverflowError
    }

    // 5: Get the result
    public void getResult() {
        // 2TODO: Implement the getResult() method
        //this.getResult(); // Note: This will cause a StackOverflowError
    }

    // 6: Enumerate the result (Example result --> $result)
    public void enumResult() {
       // this.enumResult(); // Note: This will cause a StackOverflowError
    }

    // 7: Send back to StorageToComputeEngineAPI
    public void sendResult() {
        //this.sendResult(); // Note: This will cause a StackOverflowError
    }
}
