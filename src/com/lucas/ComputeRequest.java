package com.lucas;

public interface ComputeRequest {
    InputConfig getInputConfig();
    OutputConfig getOutputConfig();
    String getDelimiter();
}
