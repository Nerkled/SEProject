package com.lucas;
import java.util.List;
public interface StorageToComputeEngineAPI{
    void write(OutputConfig output);
    // writes to a user-specified output source
    // method that checks for a symbol attached to the computed result 
    // in order to send back to the data storage system
    // reads from user-specified input sources
    List<Integer>read(InputConfig input);
}

