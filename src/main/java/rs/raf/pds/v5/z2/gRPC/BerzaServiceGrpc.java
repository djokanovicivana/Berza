package rs.raf.pds.v5.z2.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: berza_service.proto")
public final class BerzaServiceGrpc {

  private BerzaServiceGrpc() {}

  public static final String SERVICE_NAME = "rs.raf.pds.v5.z2.gRPC.BerzaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.CompanyRequest,
      rs.raf.pds.v5.z2.gRPC.CompanyList> getGetCompaniesDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCompaniesData",
      requestType = rs.raf.pds.v5.z2.gRPC.CompanyRequest.class,
      responseType = rs.raf.pds.v5.z2.gRPC.CompanyList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.CompanyRequest,
      rs.raf.pds.v5.z2.gRPC.CompanyList> getGetCompaniesDataMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.CompanyRequest, rs.raf.pds.v5.z2.gRPC.CompanyList> getGetCompaniesDataMethod;
    if ((getGetCompaniesDataMethod = BerzaServiceGrpc.getGetCompaniesDataMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getGetCompaniesDataMethod = BerzaServiceGrpc.getGetCompaniesDataMethod) == null) {
          BerzaServiceGrpc.getGetCompaniesDataMethod = getGetCompaniesDataMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.CompanyRequest, rs.raf.pds.v5.z2.gRPC.CompanyList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rs.raf.pds.v5.z2.gRPC.BerzaService", "GetCompaniesData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.CompanyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.CompanyList.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("GetCompaniesData"))
                  .build();
          }
        }
     }
     return getGetCompaniesDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Client,
      rs.raf.pds.v5.z2.gRPC.RegisterResponse> getRegisterClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterClient",
      requestType = rs.raf.pds.v5.z2.gRPC.Client.class,
      responseType = rs.raf.pds.v5.z2.gRPC.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Client,
      rs.raf.pds.v5.z2.gRPC.RegisterResponse> getRegisterClientMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Client, rs.raf.pds.v5.z2.gRPC.RegisterResponse> getRegisterClientMethod;
    if ((getRegisterClientMethod = BerzaServiceGrpc.getRegisterClientMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getRegisterClientMethod = BerzaServiceGrpc.getRegisterClientMethod) == null) {
          BerzaServiceGrpc.getRegisterClientMethod = getRegisterClientMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.Client, rs.raf.pds.v5.z2.gRPC.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rs.raf.pds.v5.z2.gRPC.BerzaService", "RegisterClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Client.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("RegisterClient"))
                  .build();
          }
        }
     }
     return getRegisterClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.AskResponse> getAskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ask",
      requestType = rs.raf.pds.v5.z2.gRPC.AskRequest.class,
      responseType = rs.raf.pds.v5.z2.gRPC.AskResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.AskResponse> getAskMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest, rs.raf.pds.v5.z2.gRPC.AskResponse> getAskMethod;
    if ((getAskMethod = BerzaServiceGrpc.getAskMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getAskMethod = BerzaServiceGrpc.getAskMethod) == null) {
          BerzaServiceGrpc.getAskMethod = getAskMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.AskRequest, rs.raf.pds.v5.z2.gRPC.AskResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rs.raf.pds.v5.z2.gRPC.BerzaService", "Ask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.AskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.AskResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("Ask"))
                  .build();
          }
        }
     }
     return getAskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BidResponse> getBidMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Bid",
      requestType = rs.raf.pds.v5.z2.gRPC.BidRequest.class,
      responseType = rs.raf.pds.v5.z2.gRPC.BidResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BidResponse> getBidMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest, rs.raf.pds.v5.z2.gRPC.BidResponse> getBidMethod;
    if ((getBidMethod = BerzaServiceGrpc.getBidMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getBidMethod = BerzaServiceGrpc.getBidMethod) == null) {
          BerzaServiceGrpc.getBidMethod = getBidMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.BidRequest, rs.raf.pds.v5.z2.gRPC.BidResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rs.raf.pds.v5.z2.gRPC.BerzaService", "Bid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BidRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BidResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("Bid"))
                  .build();
          }
        }
     }
     return getBidMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOrderRequest,
      rs.raf.pds.v5.z2.gRPC.SellOrderResponse> getSellOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SellOrder",
      requestType = rs.raf.pds.v5.z2.gRPC.SellOrderRequest.class,
      responseType = rs.raf.pds.v5.z2.gRPC.SellOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOrderRequest,
      rs.raf.pds.v5.z2.gRPC.SellOrderResponse> getSellOrderMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOrderRequest, rs.raf.pds.v5.z2.gRPC.SellOrderResponse> getSellOrderMethod;
    if ((getSellOrderMethod = BerzaServiceGrpc.getSellOrderMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getSellOrderMethod = BerzaServiceGrpc.getSellOrderMethod) == null) {
          BerzaServiceGrpc.getSellOrderMethod = getSellOrderMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.SellOrderRequest, rs.raf.pds.v5.z2.gRPC.SellOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rs.raf.pds.v5.z2.gRPC.BerzaService", "SellOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellOrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("SellOrder"))
                  .build();
          }
        }
     }
     return getSellOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOrderRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOrderResponse> getBuyOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BuyOrder",
      requestType = rs.raf.pds.v5.z2.gRPC.BuyOrderRequest.class,
      responseType = rs.raf.pds.v5.z2.gRPC.BuyOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOrderRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOrderResponse> getBuyOrderMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOrderRequest, rs.raf.pds.v5.z2.gRPC.BuyOrderResponse> getBuyOrderMethod;
    if ((getBuyOrderMethod = BerzaServiceGrpc.getBuyOrderMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getBuyOrderMethod = BerzaServiceGrpc.getBuyOrderMethod) == null) {
          BerzaServiceGrpc.getBuyOrderMethod = getBuyOrderMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.BuyOrderRequest, rs.raf.pds.v5.z2.gRPC.BuyOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "rs.raf.pds.v5.z2.gRPC.BerzaService", "BuyOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyOrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("BuyOrder"))
                  .build();
          }
        }
     }
     return getBuyOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BerzaServiceStub newStub(io.grpc.Channel channel) {
    return new BerzaServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BerzaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BerzaServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BerzaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BerzaServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BerzaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCompaniesData(rs.raf.pds.v5.z2.gRPC.CompanyRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.CompanyList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCompaniesDataMethod(), responseObserver);
    }

    /**
     */
    public void registerClient(rs.raf.pds.v5.z2.gRPC.Client request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterClientMethod(), responseObserver);
    }

    /**
     */
    public void ask(rs.raf.pds.v5.z2.gRPC.AskRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.AskResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAskMethod(), responseObserver);
    }

    /**
     */
    public void bid(rs.raf.pds.v5.z2.gRPC.BidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BidResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBidMethod(), responseObserver);
    }

    /**
     */
    public void sellOrder(rs.raf.pds.v5.z2.gRPC.SellOrderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSellOrderMethod(), responseObserver);
    }

    /**
     */
    public void buyOrder(rs.raf.pds.v5.z2.gRPC.BuyOrderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBuyOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCompaniesDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.CompanyRequest,
                rs.raf.pds.v5.z2.gRPC.CompanyList>(
                  this, METHODID_GET_COMPANIES_DATA)))
          .addMethod(
            getRegisterClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.Client,
                rs.raf.pds.v5.z2.gRPC.RegisterResponse>(
                  this, METHODID_REGISTER_CLIENT)))
          .addMethod(
            getAskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.AskRequest,
                rs.raf.pds.v5.z2.gRPC.AskResponse>(
                  this, METHODID_ASK)))
          .addMethod(
            getBidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.BidRequest,
                rs.raf.pds.v5.z2.gRPC.BidResponse>(
                  this, METHODID_BID)))
          .addMethod(
            getSellOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.SellOrderRequest,
                rs.raf.pds.v5.z2.gRPC.SellOrderResponse>(
                  this, METHODID_SELL_ORDER)))
          .addMethod(
            getBuyOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.BuyOrderRequest,
                rs.raf.pds.v5.z2.gRPC.BuyOrderResponse>(
                  this, METHODID_BUY_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class BerzaServiceStub extends io.grpc.stub.AbstractStub<BerzaServiceStub> {
    private BerzaServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BerzaServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BerzaServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BerzaServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCompaniesData(rs.raf.pds.v5.z2.gRPC.CompanyRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.CompanyList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCompaniesDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerClient(rs.raf.pds.v5.z2.gRPC.Client request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ask(rs.raf.pds.v5.z2.gRPC.AskRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.AskResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bid(rs.raf.pds.v5.z2.gRPC.BidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BidResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBidMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sellOrder(rs.raf.pds.v5.z2.gRPC.SellOrderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSellOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void buyOrder(rs.raf.pds.v5.z2.gRPC.BuyOrderRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBuyOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BerzaServiceBlockingStub extends io.grpc.stub.AbstractStub<BerzaServiceBlockingStub> {
    private BerzaServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BerzaServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BerzaServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BerzaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.CompanyList getCompaniesData(rs.raf.pds.v5.z2.gRPC.CompanyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCompaniesDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.RegisterResponse registerClient(rs.raf.pds.v5.z2.gRPC.Client request) {
      return blockingUnaryCall(
          getChannel(), getRegisterClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.AskResponse ask(rs.raf.pds.v5.z2.gRPC.AskRequest request) {
      return blockingUnaryCall(
          getChannel(), getAskMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.BidResponse bid(rs.raf.pds.v5.z2.gRPC.BidRequest request) {
      return blockingUnaryCall(
          getChannel(), getBidMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.SellOrderResponse sellOrder(rs.raf.pds.v5.z2.gRPC.SellOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getSellOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.BuyOrderResponse buyOrder(rs.raf.pds.v5.z2.gRPC.BuyOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getBuyOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BerzaServiceFutureStub extends io.grpc.stub.AbstractStub<BerzaServiceFutureStub> {
    private BerzaServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BerzaServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BerzaServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BerzaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.CompanyList> getCompaniesData(
        rs.raf.pds.v5.z2.gRPC.CompanyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCompaniesDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.RegisterResponse> registerClient(
        rs.raf.pds.v5.z2.gRPC.Client request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.AskResponse> ask(
        rs.raf.pds.v5.z2.gRPC.AskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.BidResponse> bid(
        rs.raf.pds.v5.z2.gRPC.BidRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBidMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.SellOrderResponse> sellOrder(
        rs.raf.pds.v5.z2.gRPC.SellOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSellOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.BuyOrderResponse> buyOrder(
        rs.raf.pds.v5.z2.gRPC.BuyOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBuyOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COMPANIES_DATA = 0;
  private static final int METHODID_REGISTER_CLIENT = 1;
  private static final int METHODID_ASK = 2;
  private static final int METHODID_BID = 3;
  private static final int METHODID_SELL_ORDER = 4;
  private static final int METHODID_BUY_ORDER = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BerzaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BerzaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COMPANIES_DATA:
          serviceImpl.getCompaniesData((rs.raf.pds.v5.z2.gRPC.CompanyRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.CompanyList>) responseObserver);
          break;
        case METHODID_REGISTER_CLIENT:
          serviceImpl.registerClient((rs.raf.pds.v5.z2.gRPC.Client) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.RegisterResponse>) responseObserver);
          break;
        case METHODID_ASK:
          serviceImpl.ask((rs.raf.pds.v5.z2.gRPC.AskRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.AskResponse>) responseObserver);
          break;
        case METHODID_BID:
          serviceImpl.bid((rs.raf.pds.v5.z2.gRPC.BidRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BidResponse>) responseObserver);
          break;
        case METHODID_SELL_ORDER:
          serviceImpl.sellOrder((rs.raf.pds.v5.z2.gRPC.SellOrderRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOrderResponse>) responseObserver);
          break;
        case METHODID_BUY_ORDER:
          serviceImpl.buyOrder((rs.raf.pds.v5.z2.gRPC.BuyOrderRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOrderResponse>) responseObserver);
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

  private static abstract class BerzaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BerzaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BerzaService");
    }
  }

  private static final class BerzaServiceFileDescriptorSupplier
      extends BerzaServiceBaseDescriptorSupplier {
    BerzaServiceFileDescriptorSupplier() {}
  }

  private static final class BerzaServiceMethodDescriptorSupplier
      extends BerzaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BerzaServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BerzaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BerzaServiceFileDescriptorSupplier())
              .addMethod(getGetCompaniesDataMethod())
              .addMethod(getRegisterClientMethod())
              .addMethod(getAskMethod())
              .addMethod(getBidMethod())
              .addMethod(getSellOrderMethod())
              .addMethod(getBuyOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
