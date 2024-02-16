package com.lucas;
import java.util.*;
public interface StorageToComputeEngineAPI {
    void write(Output output);
    // writes to a user-specified output source
    // method that checks for a symbol attached to the computed result 
    // in order to send back to the data storage system
    // reads from user-specified input sources
    List<Integer>read(Input input);
}

