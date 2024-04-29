package com.lucas;

import java.util.concurrent.TimeUnit;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import main.proto.UserToComputeProto.GetDataRequest;
import main.proto.UserToComputeProto.GetDataResponse;
import main.proto.UserToComputeProto.StoreDataRequest;
import main.proto.UserToComputeProto.StoreDataResponse;
import main.proto.DataStoreGrpc;
import main.proto.DataStoreGrpc.DataStoreBlockingStub;

public class LucasServerClient {
    private final DataStoreBlockingStub blockingStub;

    public LucasServerClient(Channel channel) {
        blockingStub =  DataStoreGrpc.newBlockingStub(channel);
    }

    public void createLucasServer() {
        GetDataRequest getData = GetDataRequest.newBuilder().setModel("android").setInclude(true).build();
        GetDataResponse response;
        try {
            response = blockingStub.getData(getData);
        } catch (StatusRuntimeException e) {
            return;
        }
        if (!response.errorMessage().isEmpty()) {
            System.err.println("Error: " + response.getErrorMessage());
        } else {
           System.out.println("Order number: " + response.getResult());
        }
    }
    public static void main(String[] args) throws Exception {
        String target = "localhost:50051";

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