package com.lucas2;
import com.lucas.ComputeEngine;
import com.lucas.LucasComputeEngine;
import main.proto.UserToComputeProto;
import main.proto.DataStoreGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDataStore {
    private ComputeEngine computeEngine;
    private DataStoreGrpc.DataStoreBlockingStub dataStoreStub;

    @BeforeEach
    public void setup() {
        String host = "localhost";
        int port = 8080;
        this.computeEngine = new LucasComputeEngine(host, port);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        this.dataStoreStub = DataStoreGrpc.newBlockingStub(channel);
    }

        @Test
        public void testGetData() {
        UserToComputeProto.GetDataRequest request = UserToComputeProto.GetDataRequest.newBuilder()
            .setKey("testKey")
            .build();

        UserToComputeProto.GetDataResponse expectedResponse = UserToComputeProto.GetDataResponse.newBuilder()
            .setData("testData")
            .build();

        UserToComputeProto.GetDataResponse actualResponse = computeEngine.getData(request, dataStoreStub);

        assertEquals(expectedResponse, actualResponse);
        }

    @Test
    public void testStoreData() {
        UserToComputeProto.StoreDataRequest request = UserToComputeProto.StoreDataRequest.newBuilder()
                .setKey("testKey")
                .setData("testData")
                .build();

        UserToComputeProto.StoreDataResponse expectedResponse = UserToComputeProto.StoreDataResponse.newBuilder()
                .setResult(true)
                .build();

        UserToComputeProto.StoreDataResponse actualResponse = computeEngine.putData(request, dataStoreStub);

        assertEquals(expectedResponse, actualResponse);
    }
}
