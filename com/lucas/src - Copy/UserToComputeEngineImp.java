package com.src;

public class UserToComputeEngineImp implements UserToComputeEngineAPI {

    private Input input;
    private Source source;
    private String resultDelimiter;
    private Source destination;
    private DelimiterResponse option;
    private StorageToComputeEngineAPI storageToComputeEngineAPI;

    public UserToComputeEngineImp(StorageToComputeEngineAPI storageToComputeEngineAPI) {
        this.storageToComputeEngineAPI = storageToComputeEngineAPI;
    }

    public void setInputSource(Source source) {
        this.source = source;
    }
    public void setOutputDelimiter(String resultDelimiter) {
        this.resultDelimiter = resultDelimiter;
    }

    public void setOutputDestination(Source destination) {
        this.destination = destination;
    }

    public void defaultDelimiter(DelimiterResponse option) {
        this.option = option;
    }

    public void setComputationInput(Input input) {
        this.input = input;
    }

    public void executeLucasNumberComputation() {
        // code to execute lucas number computation
    }

    public String getResultDelimiter(){
        return "";
    }
    public Source getInputSource(){
        return this.source;
    }
    public Source getOutputDestination(){
        return this.destination;
    }
    public Input getComputationInput(){
        return this.input;
    }
}
