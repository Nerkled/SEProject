
package com.lucas;
import main.proto.DataStoreGrpc.DataStoreImplBase;
import io.grpc.stub.StreamObserver;
import main.proto.UserToComputeProto;

public class LucasServerImpl extends DataStoreImplBase {
    @Override
    public void getData(UserToComputeProto.GetDataRequest request, StreamObserver<UserToComputeProto.GetDataResponse> responseObserver) {
        // Implement your logic here

        ComputeEngine computeComponent = new LucasComputeEngine("localhost", 50052);
        String result = computeComponent.compute(request.getValuesList()); // not giving correct result
        UserToComputeProto.GetDataResponse response = UserToComputeProto.GetDataResponse.newBuilder()
            .setResult(result)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}