package com.lucas;
import java.util.List;

import com.lucas.Result.ResultStatus;

public class UserToComputeEngineComponent implements UserToComputeEngineAPI {

    private final DataStorageFiles dataStorage;
    private final LucasComputeEngine computeComponent;

    public UserToComputeEngineComponent(DataStorageFiles dataStorage, LucasComputeEngine computeComponent) {
        this.dataStorage = dataStorage;
        this.computeComponent = computeComponent;
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
         try {
            // b. Request data storage to read integers from the specified location
            InputConfig inputConfig = request.getInputConfig();
            OutputConfig outputConfig = request.getOutputConfig();
            List<Integer> inputIntegers = dataStorage.read(inputConfig);
            // c. Pass the integers to the compute component
            String result = computeComponent.compute(inputIntegers);


            // d. Request data storage to write the results to the output
            Result storageResult = dataStorage.write(outputConfig, result.toString());

            // Return a suitable result status back to the user
            if (storageResult.getResult() == ResultStatus.SUCCESS) {
                return ComputeResult.SUCCESS;
            } else {
                return ComputeResult.FAILURE;
            }

        } catch (Exception e) {
            // Handle exceptions appropriately and return an error status
            return ComputeResult.FAILURE;
        }
    }
}
 