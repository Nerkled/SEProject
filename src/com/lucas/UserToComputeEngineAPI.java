package com.lucas;
public interface UserToComputeEngineAPI{
    //API 1
    ComputeResult compute(ComputeRequest request);


    public enum DelimiterResponse {
        DEFAULT,
        CUSTOM;
    }


    
    
}
