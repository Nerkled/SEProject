package com.lucas;
import java.util.List;
import java.util.Arrays;
import com.lucas.Result.ResultStatus;
@SuppressWarnings("unused")
public class StorageToComputeEngineImp implements StorageToComputeEngineAPI{
    @Override
    public List<Integer> read(InputConfig input) {
        return Arrays.asList(1);
        // Empty implementation of read method.
    }
    @Override
    public Result write(OutputConfig output, String result) {
        //write to the output file of the String result;
        return() -> Result.ResultStatus.SUCCESS;
        // lambda expression that returns a ResultStatus of SUCCESS.
    }
}
