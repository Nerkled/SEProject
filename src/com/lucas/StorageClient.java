package com.lucas;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import main.proto.DataStoreGrpc;
<<<<<<< HEAD
=======
//checkstyle warned against using wildcard imports, so I changed it to import only the necessary classes
// -Robert Bonet
>>>>>>> bcc4ee233adb46f5db9d19dc3d35033eb7cc3cda
import main.proto.UserToComputeProto.GetDataRequest;
import main.proto.UserToComputeProto.GetDataResponse;
import main.proto.UserToComputeProto.StoreDataRequest;
import main.proto.UserToComputeProto.StoreDataResponse;


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

    public int getData(int n) {
<<<<<<< HEAD
        GetDataRequest request = GetDataRequest.newBuilder().setKey(n).build();
        GetDataResponse response = blockingStub.getData(request);
        return response.getValue();
=======
        GetDataRequest request = GetDataRequest.newBuilder().setN(n).build();
        GetDataResponse response = blockingStub.getData(request);
        return response.getResult();
>>>>>>> bcc4ee233adb46f5db9d19dc3d35033eb7cc3cda
    }

    public boolean storeData(String key, String value) {
        StoreDataRequest request = StoreDataRequest.newBuilder().setKey(key).setValue(value).build();
        StoreDataResponse response = blockingStub.storeData(request);
        return response.getSuccess();
    }

    public static void main(String[] args) throws Exception {
        StorageClient client = new StorageClient("localhost", 50051);

        int result = client.getData(123);
        System.out.println("GetData response: " + result);

        boolean success = client.storeData("key1", "value1");
        System.out.println("StoreData response: " + success);

        client.shutdown();
    }
}
