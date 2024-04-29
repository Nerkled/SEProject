
package com.lucas;
import main.proto.UserToComputeProto.GetDataRequest;
import main.proto.UserToComputeProto.GetDataResponse;
import main.proto.UserToComputeProto.StoreDataRequest;
import main.proto.UserToComputeProto.StoreDataResponse;
import main.proto.DataStoreGrpc.DataStoreImplBase;
import io.grpc.stub.StreamObserver;

public class LucasServerImpl extends DataStoreImplBase {
    @Override
    public void getData(GetDataRequest request, StreamObserver<GetDataResponse> responseObserver) {
        // Implement your logic here
        int result = request.getN(); // Just an example
        GetDataResponse response = GetDataResponse.newBuilder()
            .setResult(result)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void storeData(StoreDataRequest request, StreamObserver<StoreDataResponse> responseObserver) {
        // Implement your logic here
        String key = request.getKey();
        String value = request.getValue();
        // Store the key-value pair
        boolean success = true; // Just an example
        StoreDataResponse response = StoreDataResponse.newBuilder()
            .setSuccess(success)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}