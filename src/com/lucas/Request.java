package com.lucas;

public class Request implements ComputeRequest {
    private InputConfig inputConfig;
    private OutputConfig outputConfig;
    private char delimiter;

    public Request(InputConfig inputConfig, OutputConfig outputConfig, char delimiter) {
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
    public char getDelimiter() {
        return delimiter;
    }

}
