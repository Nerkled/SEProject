//Henry Becker
package com.lucas;
import java.util.List;
import main.proto.DataStoreGrpc.DataStoreBlockingStub;
import main.proto.UserToComputeProto.StoreDataRequest;
public interface ComputeEngine{
    String compute(List<Integer> values);

    int getData(int key);

    void putData(StoreDataRequest request, DataStoreBlockingStub dataStoreStub);

    void shutdown() throws InterruptedException;
}
