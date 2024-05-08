package com.lucas;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import main.proto.DataStoreGrpc;
import main.proto.UserToComputeProto;
//checkstyle warned against using wildcard imports, so I changed it to import only the necessary classes
// -Robert Bonet


public class StorageClient {
    private final ManagedChannel channel;
    private final DataStoreGrpc.DataStoreBlockingStub blockingStub;

    public StorageClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    public StorageClient(ManagedChannel channel) {
        this.channel = channel;
        this.blockingStub = DataStoreGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public String getData(int n) {
        UserToComputeProto.GetDataRequest request = UserToComputeProto.GetDataRequest.newBuilder().addValues(n).build();
        UserToComputeProto.GetDataResponse response = blockingStub.getData(request);
        return response.getResult();
    }

    public boolean storeData(String key, String value) {
        UserToComputeProto.StoreDataRequest request = UserToComputeProto.StoreDataRequest.newBuilder().setKey(key).setValue(value).build();
        UserToComputeProto.StoreDataResponse response = blockingStub.storeData(request);
        return response.getSuccess();
    }

    public static void main(String[] args) throws Exception {
        StorageClient client = new StorageClient("localhost", 50052);

        String result = client.getData(123);
        System.out.println("GetData response: " + result);

        boolean success = client.storeData("key1", "value1");
        System.out.println("StoreData response: " + success);

        client.shutdown();
    }
}
