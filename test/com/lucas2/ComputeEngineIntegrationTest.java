package com.lucas2;

import com.lucas.UserToComputeEngineAPI;
import com.lucas.UserToComputeEngineImp;
import org.junit.Assert;
import com.lucas.ComputeEngine;
import com.lucas.ComputeRequest;
import com.lucas.ComputeResult;
import com.lucas.ImpComputeEngine;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.StorageToComputeEngineImp;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineIntegration() {
        // Set up input values for the test
        ComputeEngine engine = new ImpComputeEngine();

        //TestStorageToComputeEngine testStorage = new TestStorageToComputeEngine();
        StorageToComputeEngineAPI dataStorage = new StorageToComputeEngineImp();
        //storageToComputeEngine & compute engine
        UserToComputeEngineAPI userToComputeEngineAPI = new UserToComputeEngineImp(dataStorage, engine);

        InMemoryInputConfig input = new InMemoryInputConfig(1, 10, 25);

        InMemoryOutputConfig output = new InMemoryOutputConfig();

        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        when(mockRequest.getInputConfig()).thenReturn(input);
        when(mockRequest.getOutputConfig()).thenReturn(output);

        ComputeResult result = userToComputeEngineAPI.compute(mockRequest);

        Assert.assertEquals(ComputeResult.SUCCESS.getStatus(), result.getStatus());

        /*List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("10");
        expected.add("25");
        Assert.assertEquals(expected, output.getStrings());*/
    }
}
