package com.lucas;
import java.util.List;
public class StorageToComputeEngineImp implements StorageToComputeEngineAPI{
    public List<Integer> read(InputConfig input) {
        return null;
        // Empty implementation of read method.
    }
    public Result write(OutputConfig output, String result) {
        return() -> Result.ResultStatus.SUCCESS;
        // lambda expression that returns a ResultStatus of SUCCESS.
    }
}
