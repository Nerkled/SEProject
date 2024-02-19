package com.lucas;
import java.util.List;
public class StorageToComputeEngineImp implements StorageToComputeEngineAPI{
    private InputConfig input;
    private OutputConfig output;

    public InputConfig getInput() {
        return input;
    }

    public OutputConfig getOutput() {
        return output;
    }

    public void setInput(InputConfig input) {
        this.input = input;
    }

    public void setOutput(OutputConfig output) {
        this.output = output;
    }

    public List<Integer> read(InputConfig input) {
        return null;
        // Empty implementation 
    }

    public void write(OutputConfig output) {
        // Empty implementation 
    }
}
