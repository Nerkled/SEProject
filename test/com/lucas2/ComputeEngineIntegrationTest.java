package com.lucas2;
import com.lucas.InMemoryInputConfig;
import com.lucas.ComputeEngine;
import com.lucas.LucasComputeEngine;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.StorageToComputeEngineImp;
import com.lucas.UserToComputeEngineAPI;
import com.lucas.UserToComputeEngineImp;
import com.lucas.Request;
import com.lucas.ComputeResult;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
@SuppressWarnings("unused")
public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineIntegration() {
        // Set up input values for the test
        ComputeEngine engine = new LucasComputeEngine("localhost",0);

        //TestStorageToComputeEngine testStorage = new TestStorageToComputeEngine();
        StorageToComputeEngineAPI dataStorage = new StorageToComputeEngineImp();
        //storageToComputeEngine & compute engine
        UserToComputeEngineAPI userToComputeEngineAPI = new UserToComputeEngineImp(dataStorage, engine);

        InMemoryInputConfig input = new InMemoryInputConfig(1, 10, 25);

        InMemoryOutputConfig output = new InMemoryOutputConfig();

        Request mockRequest = Mockito.mock(Request.class);
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
