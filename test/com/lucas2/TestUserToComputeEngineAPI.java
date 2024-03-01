package com.lucas2;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.Collections;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.lucas.ComputeEngine;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.UserToComputeEngineAPI;
import com.lucas.UserToComputeEngineImp;
import com.lucas.ComputeRequest;
import com.lucas.ComputeResult;
import com.lucas.InputConfig;

import com.lucas.OutputConfig;

public class TestUserToComputeEngineAPI {

    @Test
    public void smokeTest() {
        // mock out the dependencies so that we're just checking the User To ComputeEngine
        StorageToComputeEngineAPI dataStore = Mockito.mock(StorageToComputeEngineAPI.class);
        ComputeEngine computeEngine = Mockito.mock(ComputeEngine.class);
        UserToComputeEngineAPI coordinator = new UserToComputeEngineImp(dataStore, computeEngine);
        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        ComputeResult result = coordinator.compute(mockRequest);
        Assert.assertEquals(ComputeResult.Status.SUCCESS,result.getStatus());
    }
    //ADDED TEST
    @Test
    public void testCompute() {
        // Arrange
        StorageToComputeEngineAPI dataStore = Mockito.mock(StorageToComputeEngineAPI.class);
        ComputeEngine computeEngine = Mockito.mock(ComputeEngine.class);
        UserToComputeEngineAPI coordinator = new UserToComputeEngineImp(dataStore, computeEngine);

        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        InputConfig inputConfig = Mockito.mock(InputConfig.class);
        OutputConfig outputConfig = Mockito.mock(OutputConfig.class);
        when(mockRequest.getInputConfig()).thenReturn(inputConfig);
        when(mockRequest.getOutputConfig()).thenReturn(outputConfig); 

        // Mocking the behavior of your components
        Mockito.when(dataStore.read(inputConfig)).thenReturn(Collections.emptyList());

        // Act
        ComputeResult result = coordinator.compute(mockRequest);

        // Assert
        Assert.assertEquals(ComputeResult.Status.SUCCESS, result.getStatus());
    }  
}
