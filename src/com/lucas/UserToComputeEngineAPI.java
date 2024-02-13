package com.lucas;
public interface UserToComputeEngineAPI{
    //1: specify the input soruce
    void setInputSource(Source source);
    //2: specify the output Delimiter
    void setOutputDelimiter(char resultDelimiter);
    //3: specify the output destination
    void setOutputDestination(Source destination);
    //4: give user the option to select the default delimiter
    void defaultDelimiter(DelimiterResponse option);
    //5: specify the input for the computation 
    void setComputationInput(Input input);
    //6: execute the lucas number computation
    void executeLucasNumberComputation();

    public enum DelimiterResponse {
        DEFAULT,
        CUSTOM;
    }
    
}
