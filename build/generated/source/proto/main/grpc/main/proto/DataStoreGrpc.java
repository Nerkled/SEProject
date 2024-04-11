package main.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;


@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.59.1)",
    comments = "Source: userToComputeProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataStoreGrpc {

    private DataStoreGrpc() {
    }

    public static final java.lang.String SERVICE_NAME = "main.proto.DataStore";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<main.proto.UserToComputeProto.GetDataRequest,
        main.proto.UserToComputeProto.GetDataResponse> getGetDataMethod;

    public static io.grpc.MethodDescriptor<main.proto.UserToComputeProto.GetDataRequest,
        main.proto.UserToComputeProto.GetDataResponse> getGetDataMethod() {
        io.grpc.MethodDescriptor<main.proto.UserToComputeProto.GetDataRequest,
            main.proto.UserToComputeProto.GetDataResponse> getGetDataMethod;
        if ((getGetDataMethod = DataStoreGrpc.getGetDataMethod) == null) {
            synchronized (DataStoreGrpc.class) {
                if ((getGetDataMethod = DataStoreGrpc.getGetDataMethod) == null) {
                    DataStoreGrpc.getGetDataMethod = getGetDataMethod = io.grpc.MethodDescriptor
                        .<main.proto.UserToComputeProto.GetDataRequest,
                            main.proto.UserToComputeProto.GetDataResponse>newBuilder()
                        .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                        .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getData"))
                        .setSampledToLocalTracing(true)
                        .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            main.proto.UserToComputeProto.GetDataRequest.getDefaultInstance()))
                        .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            main.proto.UserToComputeProto.GetDataResponse.getDefaultInstance()))
                        .setSchemaDescriptor(new DataStoreMethodDescriptorSupplier("getData"))
                        .build();
                }
            }
        }
        return getGetDataMethod;
    }

    private static volatile io.grpc.MethodDescriptor<main.proto.UserToComputeProto.StoreDataRequest,
        main.proto.UserToComputeProto.StoreDataResponse> getStoreDataMethod;

    public static io.grpc.MethodDescriptor<main.proto.UserToComputeProto.StoreDataRequest,
        main.proto.UserToComputeProto.StoreDataResponse> getStoreDataMethod() {
        io.grpc.MethodDescriptor<main.proto.UserToComputeProto.StoreDataRequest,
            main.proto.UserToComputeProto.StoreDataResponse> getStoreDataMethod;
        if ((getStoreDataMethod = DataStoreGrpc.getStoreDataMethod) == null) {
            synchronized (DataStoreGrpc.class) {
                if ((getStoreDataMethod = DataStoreGrpc.getStoreDataMethod) == null) {
                    DataStoreGrpc.getStoreDataMethod = getStoreDataMethod = io.grpc.MethodDescriptor
                        .<main.proto.UserToComputeProto.StoreDataRequest,
                            main.proto.UserToComputeProto.StoreDataResponse>newBuilder()
                        .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                        .setFullMethodName(generateFullMethodName(SERVICE_NAME, "storeData"))
                        .setSampledToLocalTracing(true)
                        .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            main.proto.UserToComputeProto.StoreDataRequest.getDefaultInstance()))
                        .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            main.proto.UserToComputeProto.StoreDataResponse.getDefaultInstance()))
                        .setSchemaDescriptor(new DataStoreMethodDescriptorSupplier("storeData"))
                        .build();
                }
            }
        }
        return getStoreDataMethod;
    }

    public static DataStoreStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<DataStoreStub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<DataStoreStub>() {
                @java.lang.Override
                public DataStoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                    return new DataStoreStub(channel, callOptions);
                }
            };
        return DataStoreStub.newStub(factory, channel);
    }

    public static DataStoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<DataStoreBlockingStub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<DataStoreBlockingStub>() {
                @java.lang.Override
                public DataStoreBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                    return new DataStoreBlockingStub(channel, callOptions);
                }
            };
        return DataStoreBlockingStub.newStub(factory, channel);
    }

    public static DataStoreFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<DataStoreFutureStub> factory =
            new io.grpc.stub.AbstractStub.StubFactory<DataStoreFutureStub>() {
                @java.lang.Override
                public DataStoreFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                    return new DataStoreFutureStub(channel, callOptions);
                }
            };
        return DataStoreFutureStub.newStub(factory, channel);
    }

    public interface AsyncService {

        default void getData(main.proto.UserToComputeProto.GetDataRequest request,
            io.grpc.stub.StreamObserver<main.proto.UserToComputeProto.GetDataResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataMethod(), responseObserver);
        }

        default void storeData(main.proto.UserToComputeProto.StoreDataRequest request,
            io.grpc.stub.StreamObserver<main.proto.UserToComputeProto.StoreDataResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStoreDataMethod(), responseObserver);
        }
    }

    public static abstract class DataStoreImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return DataStoreGrpc.bindService(this);
        }
    }

    public static final class DataStoreStub extends io.grpc.stub.AbstractAsyncStub<DataStoreStub> {
        private DataStoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected DataStoreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataStoreStub(channel, callOptions);
        }

        public void getData(main.proto.UserToComputeProto.GetDataRequest request,
            io.grpc.stub.StreamObserver<main.proto.UserToComputeProto.GetDataResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                getChannel().newCall(getGetDataMethod(), getCallOptions()), request, responseObserver);
        }

        public void storeData(main.proto.UserToComputeProto.StoreDataRequest request,
            io.grpc.stub.StreamObserver<main.proto.UserToComputeProto.StoreDataResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(
                getChannel().newCall(getStoreDataMethod(), getCallOptions()), request, responseObserver);
        }
    }

    public static final class DataStoreBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataStoreBlockingStub> {
        private DataStoreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected DataStoreBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataStoreBlockingStub(channel, callOptions);
        }

        public main.proto.UserToComputeProto.GetDataResponse getData(
            main.proto.UserToComputeProto.GetDataRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                getChannel(), getGetDataMethod(), getCallOptions(), request);
        }

        public main.proto.UserToComputeProto.StoreDataResponse storeData(
            main.proto.UserToComputeProto.StoreDataRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(
                getChannel(), getStoreDataMethod(), getCallOptions(), request);
        }
    }

    public static final class DataStoreFutureStub extends io.grpc.stub.AbstractFutureStub<DataStoreFutureStub> {
        private DataStoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected DataStoreFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataStoreFutureStub(channel, callOptions);
        }

        public com.google.common.util.concurrent.ListenableFuture<main.proto.UserToComputeProto.GetDataResponse> getData(
            main.proto.UserToComputeProto.GetDataRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                getChannel().newCall(getGetDataMethod(), getCallOptions()), request);
        }

        public com.google.common.util.concurrent.ListenableFuture<main.proto.UserToComputeProto.StoreDataResponse> storeData(
            main.proto.UserToComputeProto.StoreDataRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(
                getChannel().newCall(getStoreDataMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_GET_DATA = 0;
    private static final int METHODID_STORE_DATA = 1;

    private static final class MethodHandlers<Req, Resp> implements
        io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
        io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
        io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
        io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final AsyncService serviceImpl;
        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_DATA:
                    serviceImpl.getData((main.proto.UserToComputeProto.GetDataRequest) request,
                        (io.grpc.stub.StreamObserver<main.proto.UserToComputeProto.GetDataResponse>) responseObserver);
                    break;
                case METHODID_STORE_DATA:
                    serviceImpl.storeData((main.proto.UserToComputeProto.StoreDataRequest) request,
                        (io.grpc.stub.StreamObserver<main.proto.UserToComputeProto.StoreDataResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
            io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
            .addMethod(
                getGetDataMethod(),
                io.grpc.stub.ServerCalls.asyncUnaryCall(
                    new MethodHandlers<main.proto.UserToComputeProto.GetDataRequest,
                        main.proto.UserToComputeProto.GetDataResponse>(
                        service, METHODID_GET_DATA)))
            .addMethod(
                getStoreDataMethod(),
                io.grpc.stub.ServerCalls.asyncUnaryCall(
                    new MethodHandlers<main.proto.UserToComputeProto.StoreDataRequest,
                        main.proto.UserToComputeProto.StoreDataResponse>(
                        service, METHODID_STORE_DATA)))
            .build();
    }

    private static abstract class DataStoreBaseDescriptorSupplier
        implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        DataStoreBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return main.proto.UserToComputeProto.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("DataStore");
        }
    }

    private static final class DataStoreFileDescriptorSupplier extends DataStoreBaseDescriptorSupplier {
        DataStoreFileDescriptorSupplier() {
        }
    }

    private static final class DataStoreMethodDescriptorSupplier extends DataStoreBaseDescriptorSupplier
        implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final java.lang.String methodName;

        DataStoreMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (DataStoreGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                        .setSchemaDescriptor(new DataStoreFileDescriptorSupplier())
                        .addMethod(getGetDataMethod())
                        .addMethod(getStoreDataMethod())
                        .build();
                }
            }
        }
        return result;
    }
}
