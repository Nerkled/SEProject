
package com.lucas;
import main.proto.DataStoreGrpc.DataStoreImplBase;
import io.grpc.stub.StreamObserver;
import main.proto.UserToComputeProto;
import com.lucas.UserToComputeEngineComponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LucasServerImpl extends DataStoreImplBase {
    @Override
    public void getData(UserToComputeProto.GetDataRequest request, StreamObserver<UserToComputeProto.GetDataResponse> responseObserver) {
        // Implement your logic here
        DataStorageFiles datastore = new DataStorageFiles();
        LucasComputeEngine computeComponent = new LucasComputeEngine("localhost", 50052);
        UserToComputeEngineAPI dataServer = new UserToComputeEngineComponent(datastore,computeComponent, 10);
        InputConfig input;
        if(request.hasFileName()){
            input = new FileInputConfig(request.getFileName());
        }else{
            input = new InMemoryInputConfig(request.getValuesList());
        }
        OutputConfig output = new FileOutputConfig("LucasOutput.txt");

        Request request2 = new Request(input,output,"\n");

        ComputeResult result = dataServer.compute(request2);
        String userResponse;
        if(result.getStatus()==ComputeResult.Status.SUCCESS){
            try {
                userResponse = Files.readAllLines(Paths.get("LucasOutput.txt")).toString();
            }
            catch(IOException E){
                throw new RuntimeException(E);
            }
        }else {
            userResponse = "Error";
        }
        UserToComputeProto.GetDataResponse response = UserToComputeProto.GetDataResponse.newBuilder().setResult(userResponse).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}