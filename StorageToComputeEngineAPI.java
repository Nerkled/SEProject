public interface StorageToComputeEngineAPI{
    void write (Output output);
    //writes to user specified output source
    //if method that is checking for symbol attached to computed result 
    //in order to send back to data storage system   
    void read (Input input);
    // reads in user specified input sources
}