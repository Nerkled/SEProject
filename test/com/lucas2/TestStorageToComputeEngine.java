package com.lucas2;

import com.lucas.StorageToComputeEngineAPI;
import com.lucas.StorageToComputeEngineImp;
import com.lucas.Result.ResultStatus;
import com.lucas.InputConfig;
import com.lucas.OutputConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestStorageToComputeEngine {

    @Test
    public void smokeTestRead() {
        InputConfig inputConfig = Mockito.mock(InputConfig.class);
        StorageToComputeEngineAPI storage = new StorageToComputeEngineImp();
        Assert.assertEquals(1L, storage.read(inputConfig));
    }

    @Test
    public void smokeTestWrite() {
        OutputConfig outputConfig = Mockito.mock(OutputConfig.class);
        StorageToComputeEngineAPI storage = new StorageToComputeEngineImp();
        Assert.assertEquals(ResultStatus.SUCCESS, storage.write(outputConfig, "result").getResult());
    }
}