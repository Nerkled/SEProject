package com.lucas;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;

import main.proto.DataStoreGrpc;
import main.proto.DataStoreGrpc.DataStoreBlockingStub;
import main.proto.UserToComputeProto;
import main.proto.UserToComputeProto.GetDataRequest;
import main.proto.UserToComputeProto.GetDataResponse;
import main.proto.UserToComputeProto.StoreDataRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LucasComputeEngine implements ComputeEngine {
    private final ManagedChannel channel;
    private final DataStoreGrpc.DataStoreBlockingStub blockingStub;
    private Map<Integer, BigInteger> lucasMap = new HashMap<>();

    public LucasComputeEngine(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.blockingStub = DataStoreGrpc.newBlockingStub(channel);
        this.lucasMap = new HashMap<>();


    }

    @Override
    public int getData(int key) {
        GetDataRequest request = GetDataRequest.newBuilder().setN(key).build();
        GetDataResponse response = blockingStub.getData(request);
        return response.getResult();
    }

    @Override
    public void putData(StoreDataRequest request, DataStoreBlockingStub dataStoreStub) {
        UserToComputeProto.StoreDataResponse response = blockingStub.storeData(request);
        if (!response.getSuccess()) {
            throw new RuntimeException("Failed to store data");
        }
    }
    //slow
    public String slowCompute(List<Integer> values) {
        StringBuilder result = new StringBuilder();
        for (int value : values) {
            result.append(slowComputeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    public String slowCompute(int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value; i++) {
            result.append(slowComputeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    public String compute(List<Integer> values) {
        StringBuilder result = new StringBuilder();
        for (int value : values) {
            result.append(computeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    public String compute(int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value; i++) {
            result.append(computeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    private String slowComputeLucasSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sequence.append(slowLucas(i)).append(" ");
        }
        return sequence.toString().trim();
    }

    private String computeLucasSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sequence.append(lucas(i)).append(" ");
        }
        return sequence.toString().trim();
    }

    private BigInteger slowLucas(int n) {
        if (n == 0) {
            BigInteger two = BigInteger.valueOf(2);
            return two;
        }
        if (n == 1) {
            BigInteger one = BigInteger.valueOf(1);
            return one;
        }
        BigInteger result = lucas(n - 1).add(lucas(n - 2));
       // int result = lucas(n - 1) + lucas(n - 2);
        //System.out.println(result); // remove when done testing 
        return result;
    }

    private BigInteger lucas(int n) {
        if(lucasMap.containsKey(n)) {
            return lucasMap.get(n);
        }
        if (n == 0) {
            BigInteger two = BigInteger.valueOf(2);
            lucasMap.put(0,two);
            return two;
        }
        if (n == 1) {
            BigInteger one = BigInteger.valueOf(1);
            lucasMap.put(1,one);
            return one;
        }
        BigInteger result = lucas(n - 1).add(lucas(n - 2));
       // int result = lucas(n - 1) + lucas(n - 2);
        //System.out.println(result); // remove when done testing 
        return result;
    }

    @Override
    public void shutdown() throws InterruptedException {
        throw new UnsupportedOperationException("Unimplemented method 'shutdown'");
    }
}