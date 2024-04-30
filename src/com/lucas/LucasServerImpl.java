
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
        ComputeEngine computeComponent = new LucasComputeEngine("localhost", 50052);
        String result = computeComponent.compute(request.getValuesList()); // Just an example
        GetDataResponse response = GetDataResponse.newBuilder()
            .setResult(result)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}