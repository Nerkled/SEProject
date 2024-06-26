package com.lucas2;
import org.junit.jupiter.api.Test;
import com.lucas.ComputeEngine;
import com.lucas.LucasComputeEngine;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
public class TestDataStore {
    

    @Test
    public void smokeTestCompute() {
        // The computation component has very simple inputs/outputs and no dependencies, so we can
        // write a smoke test with no mocks at all
        List<Integer> values = new ArrayList<>();
        values.add(1);
        ComputeEngine engine = new LucasComputeEngine("localhost", 8080);
        
        Assert.assertEquals("2 1", engine.compute(values));
    } 
}

 /*   @Test
    public void testComputeWithProto() {
        // Create a mock data store
        TestDataStore dataStore = new TestDataStore();

        // Create a mock gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        // Create a gRPC client stub
        DataStoreGrpc.DataStoreBlockingStub stub = DataStoreGrpc.newBlockingStub(channel);

        // Create a request using the proto generated file
        GetDataRequest request = GetDataRequest.newBuilder()
            .setN(1)
            .build();

        // Make a gRPC call to the data store
        UserToComputeProto.GetDataResponse response = stub.getData(request);

        // Verify the response
        Assert.assertEquals("testValue", response.getResult()); // Update the field name to match your proto definition
    }
}
 */
