package com.lucas;


import java.io.File;

import java.util.concurrent.TimeUnit;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import main.proto.DataStoreGrpc;
import main.proto.DataStoreGrpc.DataStoreBlockingStub;
import main.proto.UserToComputeProto;

public class LucasServerClient {
    private final DataStoreBlockingStub blockingStub;

    public LucasServerClient(Channel channel) {
        blockingStub =  DataStoreGrpc.newBlockingStub(channel);
    }

    public void createLucasServer() {

        String inputPath = "test" + File.separatorChar + "com" + File.separatorChar + "lucas2" + File.separatorChar + "testInputFile.test";
        UserToComputeProto.GetDataRequest getData = UserToComputeProto.GetDataRequest.newBuilder().setFileName(inputPath).build();

        UserToComputeProto.GetDataResponse response;
        try {
            response = blockingStub.getData(getData);
        } catch (StatusRuntimeException e) {
            return;
        }
        if (!response.getErrorMessage().isEmpty()) {
            System.err.println("Error: " + response.getErrorMessage());
        } else {
            System.out.println("Order number: " + response.getResult());
        }
    }
    public static void main(String[] args) throws Exception {
        String target = "localhost:50051"; //instead of local host it would be the name of server
        //modify build.gradle to make javascript
        //use javascript to use the button

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
            .build();
        try {
            LucasServerClient client = new LucasServerClient(channel);
            client.createLucasServer();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}