package com.lucas;

public class Request implements ComputeRequest {
    private InputConfig inputConfig;
    private OutputConfig outputConfig;
    private String delimiter;

    public Request(InputConfig inputConfig, OutputConfig outputConfig, String delimiter) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
        this.delimiter = delimiter;
    }

    @Override
    public InputConfig getInputConfig() {
        return inputConfig;
    }

    @Override
    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

}
