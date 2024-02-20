package com.lucas2;
<<<<<<< HEAD
import java.util.ArrayList;
import com.lucas.inputConfig;
import com.lucas.outputConfig;
import java.util.List;

public class InMemoryImpStorageToComputeEngine{
    private List<Integer> inputIntegers;
    private List<String> outputStrings;
    public InMemoryImpStorageToComputeEngine(){
        this.inputIntegers = new ArrayList<Integer>(inputConfig.getIntegers());
        this.outputStrings = new ArrayList<String>(outputConfig.getStrings());
        
=======
import com.lucas.InputConfig;
import com.lucas.OutputConfig;
import com.lucas.Result;
import com.lucas.StorageToComputeEngineAPI;
public class InMemoryImpStorageToComputeEngine implements StorageToComputeEngineAPI {

>>>>>>> e99de9b0fcc2b1cc25ef1913cd028663b62359a1
    }
    @Override
    public Result write(OutputConfig output, String result) {
        // Test code is allowed to assume it's getting the right types; this will fail with a ClassCastException if it gets
        // another type of input. For production code, we'd want some better user input validation
        ((InMemoryOutputConfig)output).getStrings().add(result);
        return () -> Result.ResultStatus.SUCCESS;
    }
}
