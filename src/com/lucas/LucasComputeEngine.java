package com.lucas;
import java.util.List;

import main.proto.DataStoreGrpc;
import main.proto.DataStoreGrpc.DataStoreBlockingStub;
import main.proto.UserToComputeProto;
import main.proto.UserToComputeProto.GetDataRequest;
import main.proto.UserToComputeProto.GetDataResponse;
import main.proto.UserToComputeProto.StoreDataRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LucasComputeEngine implements ComputeEngine {
    private final ManagedChannel channel;
    private final DataStoreGrpc.DataStoreBlockingStub blockingStub;

    public LucasComputeEngine(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.blockingStub = DataStoreGrpc.newBlockingStub(channel);
    }

    @Override
    public int getData(int key) {
        GetDataRequest request = GetDataRequest.newBuilder().setKey(key).build();
        GetDataResponse response = blockingStub.getData(request);
        return response.getValue();
    }

    @Override
    public void putData(StoreDataRequest request, DataStoreBlockingStub dataStoreStub) {
        UserToComputeProto.StoreDataResponse response = blockingStub.storeData(request);
        if (!response.getSuccess()) {
            throw new RuntimeException("Failed to store data");
        }
    }

    @Override
    public String compute(List<Integer> values) {
        StringBuilder result = new StringBuilder();
        for (int value : values) {
            result.append(computeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    public String compute(int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value; i++) {
            result.append(computeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    private String computeLucasSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sequence.append(lucas(i)).append(" ");
        }
        return sequence.toString().trim();
    }

    private int lucas(int n) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return lucas(n - 1) + lucas(n - 2);
    }

    @Override
    public void shutdown() throws InterruptedException {
        throw new UnsupportedOperationException("Unimplemented method 'shutdown'");
    }
}