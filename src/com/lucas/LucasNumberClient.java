package com.lucas;

import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import phoneservice.PhoneOrderServiceGrpc.PhoneOrderServiceBlockingStub;
import phoneservice.PhoneService.PhoneOrderRequest;
import phoneservice.PhoneService.PhoneOrderResponse;

public class LucasNumberClient { // Boilerplate TODO: change to <servicename>Client
	 private final LucasNumberServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

	  public LucasNumberClient(Channel channel) {
	    blockingStub = LucasNumberServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
	  }

	  // Boilerplate TODO: replace this method with actual client call/response logic
	  public void order() {
	    LucasNumberRequest request = LucasNumberRequest.newBuilder().setModel("android").setIncludeWarranty(true).build();
	    LucasNumberResponse response;
	    try {
	      response = blockingStub.createLucasNumber(request);
	    } catch (StatusRuntimeException e) {
	      return;
	    }
	    if (response.hasErrorMessage()) {
	    	System.err.println("Error: " + response.getErrorMessage());
	    } else {
	    	System.out.println("Order number: " + response.getOrderNumber());
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    String target = "localhost:50051";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

	    ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
	        .build();
	    try {
	      LucasNumberClient client = new LucasNumberClient(channel); // Boilerplate TODO: update to this class name
	      client.order();
	    } finally {
	      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }
}
