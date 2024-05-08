package com.lucas;
import java.util.List;
import main.proto.DataStoreGrpc.DataStoreBlockingStub;
import main.proto.UserToComputeProto;

public interface ComputeEngine{
    String compute(List<Integer> values);

    String slowCompute(List<Integer> values);

    String getData(int key);

    void putData(UserToComputeProto.StoreDataRequest request, DataStoreBlockingStub dataStoreStub);

    void shutdown() throws InterruptedException;
}