package com.lucas;
public interface LucasComputerAPI {

    //1: Initialize the API
    void initialize();
    //2:Get Write Data
    void read(Input input);
    //3: Write Data
    void write(Output output);
    //4: Pass Data through LucasComputingModule
    void computeLucas(Input input);
    //4: Get Result(Throw Errors if any, else return result)
    void getResult();
    //5: Enum the result (Example result --> $result )
    void enumResult();
    //6: Send back to StorageToComputeEngineAPI
    void sendResult();
} 
