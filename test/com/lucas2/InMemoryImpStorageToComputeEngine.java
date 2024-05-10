package com.lucas2;
import com.lucas.InMemoryInputConfig;
import com.lucas.InputConfig;
import com.lucas.Result;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.OutputConfig;

import java.util.List;
public class InMemoryImpStorageToComputeEngine implements StorageToComputeEngineAPI {

    @Override
    public List<Integer> read(InputConfig input) {
        // Test code is allowed to assume it's getting the right types; this will fail with a ClassCastException if it gets
        // another type of input. For production code, we'd want some better user input validation
        return ((InMemoryInputConfig)input).getIntegers();
    }
    @Override
    public Result write(OutputConfig output, String result) {
        // Test code is allowed to assume it's getting the right types; this will fail with a ClassCastException if it gets
        // another type of input. For production code, we'd want some better user input validation
        ((InMemoryOutputConfig)output).getStrings().add(result);
        return () -> Result.ResultStatus.SUCCESS;
    }
}
