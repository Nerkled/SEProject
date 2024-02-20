package com.lucas2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.lucas.ComputeEngine;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.UserToComputeEngineAPI;
import com.lucas.UserToComputeEngineImp;
import com.lucas.ComputeRequest;
import com.lucas.ComputeResult;

public class TestUserToComputeEngineAPI {

    @Test
    public void smokeTest() {
        // mock out the dependencies so that we're just checking the User To ComputeEngine
        StorageToComputeEngineAPI dataStore = Mockito.mock(StorageToComputeEngineAPI.class);
        ComputeEngine computeEngine = Mockito.mock(ComputeEngine.class);
        UserToComputeEngineAPI coord = new UserToComputeEngineImp(dataStore, computeEngine);
        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        ComputeResult result = coord.compute(mockRequest);
        Assert.assertEquals(result.getStatus(), ComputeResult.Status.SUCCESS);
    }
}
