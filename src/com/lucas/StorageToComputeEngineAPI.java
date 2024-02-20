package com.lucas;
public interface StorageToComputeEngineAPI{
    Result write(OutputConfig output, String result);
    // writes to a user-specified output source
    // method that checks for a symbol attached to the computed result 
    // in order to send back to the data storage system
    // reads from user-specified input sources
    Iterable<Integer> read(InputConfig input);
}

