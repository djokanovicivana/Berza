// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * Protobuf type {@code rs.raf.pds.v5.z2.gRPC.SubscribeRequest}
 */
public  final class SubscribeRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rs.raf.pds.v5.z2.gRPC.SubscribeRequest)
    SubscribeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SubscribeRequest.newBuilder() to construct.
  private SubscribeRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SubscribeRequest() {
    clientId_ = "";
    symbols_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SubscribeRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            clientId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              symbols_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000002;
            }
            symbols_.add(s);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        symbols_ = symbols_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_SubscribeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_SubscribeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.SubscribeRequest.class, rs.raf.pds.v5.z2.gRPC.SubscribeRequest.Builder.class);
  }

  private int bitField0_;
  public static final int CLIENTID_FIELD_NUMBER = 1;
  private volatile java.lang.Object clientId_;
  /**
   * <code>string clientId = 1;</code>
   */
  public java.lang.String getClientId() {
    java.lang.Object ref = clientId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientId_ = s;
      return s;
    }
  }
  /**
   * <code>string clientId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getClientIdBytes() {
    java.lang.Object ref = clientId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SYMBOLS_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList symbols_;
  /**
   * <code>repeated string symbols = 2;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getSymbolsList() {
    return symbols_;
  }
  /**
   * <code>repeated string symbols = 2;</code>
   */
  public int getSymbolsCount() {
    return symbols_.size();
  }
  /**
   * <code>repeated string symbols = 2;</code>
   */
  public java.lang.String getSymbols(int index) {
    return symbols_.get(index);
  }
  /**
   * <code>repeated string symbols = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSymbolsBytes(int index) {
    return symbols_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getClientIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, clientId_);
    }
    for (int i = 0; i < symbols_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, symbols_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getClientIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, clientId_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < symbols_.size(); i++) {
        dataSize += computeStringSizeNoTag(symbols_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getSymbolsList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.SubscribeRequest)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.SubscribeRequest other = (rs.raf.pds.v5.z2.gRPC.SubscribeRequest) obj;

    boolean result = true;
    result = result && getClientId()
        .equals(other.getClientId());
    result = result && getSymbolsList()
        .equals(other.getSymbolsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CLIENTID_FIELD_NUMBER;
    hash = (53 * hash) + getClientId().hashCode();
    if (getSymbolsCount() > 0) {
      hash = (37 * hash) + SYMBOLS_FIELD_NUMBER;
      hash = (53 * hash) + getSymbolsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.SubscribeRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code rs.raf.pds.v5.z2.gRPC.SubscribeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rs.raf.pds.v5.z2.gRPC.SubscribeRequest)
      rs.raf.pds.v5.z2.gRPC.SubscribeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_SubscribeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_SubscribeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.SubscribeRequest.class, rs.raf.pds.v5.z2.gRPC.SubscribeRequest.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.SubscribeRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      clientId_ = "";

      symbols_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_SubscribeRequest_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SubscribeRequest getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.SubscribeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SubscribeRequest build() {
      rs.raf.pds.v5.z2.gRPC.SubscribeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SubscribeRequest buildPartial() {
      rs.raf.pds.v5.z2.gRPC.SubscribeRequest result = new rs.raf.pds.v5.z2.gRPC.SubscribeRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.clientId_ = clientId_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        symbols_ = symbols_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.symbols_ = symbols_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof rs.raf.pds.v5.z2.gRPC.SubscribeRequest) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.SubscribeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.SubscribeRequest other) {
      if (other == rs.raf.pds.v5.z2.gRPC.SubscribeRequest.getDefaultInstance()) return this;
      if (!other.getClientId().isEmpty()) {
        clientId_ = other.clientId_;
        onChanged();
      }
      if (!other.symbols_.isEmpty()) {
        if (symbols_.isEmpty()) {
          symbols_ = other.symbols_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureSymbolsIsMutable();
          symbols_.addAll(other.symbols_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      rs.raf.pds.v5.z2.gRPC.SubscribeRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (rs.raf.pds.v5.z2.gRPC.SubscribeRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object clientId_ = "";
    /**
     * <code>string clientId = 1;</code>
     */
    public java.lang.String getClientId() {
      java.lang.Object ref = clientId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string clientId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getClientIdBytes() {
      java.lang.Object ref = clientId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string clientId = 1;</code>
     */
    public Builder setClientId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      clientId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string clientId = 1;</code>
     */
    public Builder clearClientId() {
      
      clientId_ = getDefaultInstance().getClientId();
      onChanged();
      return this;
    }
    /**
     * <code>string clientId = 1;</code>
     */
    public Builder setClientIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      clientId_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList symbols_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureSymbolsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        symbols_ = new com.google.protobuf.LazyStringArrayList(symbols_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getSymbolsList() {
      return symbols_.getUnmodifiableView();
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public int getSymbolsCount() {
      return symbols_.size();
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public java.lang.String getSymbols(int index) {
      return symbols_.get(index);
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSymbolsBytes(int index) {
      return symbols_.getByteString(index);
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public Builder setSymbols(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSymbolsIsMutable();
      symbols_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public Builder addSymbols(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSymbolsIsMutable();
      symbols_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public Builder addAllSymbols(
        java.lang.Iterable<java.lang.String> values) {
      ensureSymbolsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, symbols_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public Builder clearSymbols() {
      symbols_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 2;</code>
     */
    public Builder addSymbolsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureSymbolsIsMutable();
      symbols_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rs.raf.pds.v5.z2.gRPC.SubscribeRequest)
  }

  // @@protoc_insertion_point(class_scope:rs.raf.pds.v5.z2.gRPC.SubscribeRequest)
  private static final rs.raf.pds.v5.z2.gRPC.SubscribeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.SubscribeRequest();
  }

  public static rs.raf.pds.v5.z2.gRPC.SubscribeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SubscribeRequest>
      PARSER = new com.google.protobuf.AbstractParser<SubscribeRequest>() {
    @java.lang.Override
    public SubscribeRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SubscribeRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SubscribeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SubscribeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.SubscribeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

