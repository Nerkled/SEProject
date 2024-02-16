package com.lucas;
public interface UserToComputeEngineAPI{
    //1: specify the input soruce
    void setInputSource(Source source);
    //2: specify the output Delimiter
    void setOutputDelimiter(String resultDelimiter);
    //3: specify the output destination
    void setOutputDestination(Source destination);
    //4: give user the option to select the default delimiter
    void defaultDelimiter(DelimiterResponse option);
    //6: execute the lucas number computation
    void executeLucasNumberComputation();
    //7: get the Delimiter that the user chooses
    String getResultDelimiter();
    //8: get Input Source
    Source getInputSource();
    //9: get output destination
    Source getOutputDestination();



    public enum DelimiterResponse {
        DEFAULT,
        CUSTOM;
    }


    
    
}
