package com.lucas;
import java.util.List;
import com.lucas.Result.ResultStatus;
@SuppressWarnings("unused")
public class StorageToComputeEngineImp implements StorageToComputeEngineAPI{
    @Override
    public List<Integer> read(InputConfig input) {
        return null;
        // Empty implementation of read method.
    }
    @Override
    public Result write(OutputConfig output, String result) {
        return() -> Result.ResultStatus.SUCCESS;
        // lambda expression that returns a ResultStatus of SUCCESS.
    }
}
