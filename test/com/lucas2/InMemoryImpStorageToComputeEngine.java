package com.lucas2;
import java.util.ArrayList;

import java.util.List;

public class InMemoryImpStorageToComputeEngine{
    private List<Integer> inputIntegers;
    private List<String> outputStrings;
    public InMemoryImpStorageToComputeEngine(){
        this.inputIntegers = new ArrayList<>();
        this.outputStrings = new ArrayList<>();
    }
    public void readInput(InMemoryInputConfig inputConfig){
        this.inputIntegers = new ArrayList<>(inputConfig.getIntegers());
    }
    public void writeOutput(InMemoryOutputConfig outputConfig){
        this.outputStrings = new ArrayList<>(outputConfig.getStrings());
    }
    public List<Integer> getInMemoryInput(){
        return new ArrayList<>(inputIntegers);
    }
    public List<String> getInMemoryOutput(){
        return new ArrayList<>(outputStrings);
    }
}
