package com.lucas;
import java.util.List;
public class StorageToComputeEngineImp implements StorageToComputeEngineAPI {
    private Input input;
    private Output output;

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public List<Integer> read(Input input) {
        return null;
        // Empty implementation 
    }

    public void write(Output output) {
        // Empty implementation 
    }
}
