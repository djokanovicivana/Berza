// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * Protobuf type {@code rs.raf.pds.v5.z2.gRPC.BuyOffer}
 */
public  final class BuyOffer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rs.raf.pds.v5.z2.gRPC.BuyOffer)
    BuyOfferOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BuyOffer.newBuilder() to construct.
  private BuyOffer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BuyOffer() {
    symbol_ = "";
    totalShares_ = 0;
    price_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BuyOffer(
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

            symbol_ = s;
            break;
          }
          case 16: {

            totalShares_ = input.readInt32();
            break;
          }
          case 25: {

            price_ = input.readDouble();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_BuyOffer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_BuyOffer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.BuyOffer.class, rs.raf.pds.v5.z2.gRPC.BuyOffer.Builder.class);
  }

  public static final int SYMBOL_FIELD_NUMBER = 1;
  private volatile java.lang.Object symbol_;
  /**
   * <code>string symbol = 1;</code>
   */
  public java.lang.String getSymbol() {
    java.lang.Object ref = symbol_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      symbol_ = s;
      return s;
    }
  }
  /**
   * <code>string symbol = 1;</code>
   */
  public com.google.protobuf.ByteString
      getSymbolBytes() {
    java.lang.Object ref = symbol_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      symbol_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOTALSHARES_FIELD_NUMBER = 2;
  private int totalShares_;
  /**
   * <code>int32 totalShares = 2;</code>
   */
  public int getTotalShares() {
    return totalShares_;
  }

  public static final int PRICE_FIELD_NUMBER = 3;
  private double price_;
  /**
   * <code>double price = 3;</code>
   */
  public double getPrice() {
    return price_;
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
    if (!getSymbolBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, symbol_);
    }
    if (totalShares_ != 0) {
      output.writeInt32(2, totalShares_);
    }
    if (price_ != 0D) {
      output.writeDouble(3, price_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSymbolBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, symbol_);
    }
    if (totalShares_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, totalShares_);
    }
    if (price_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, price_);
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
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.BuyOffer)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.BuyOffer other = (rs.raf.pds.v5.z2.gRPC.BuyOffer) obj;

    boolean result = true;
    result = result && getSymbol()
        .equals(other.getSymbol());
    result = result && (getTotalShares()
        == other.getTotalShares());
    result = result && (
        java.lang.Double.doubleToLongBits(getPrice())
        == java.lang.Double.doubleToLongBits(
            other.getPrice()));
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
    hash = (37 * hash) + SYMBOL_FIELD_NUMBER;
    hash = (53 * hash) + getSymbol().hashCode();
    hash = (37 * hash) + TOTALSHARES_FIELD_NUMBER;
    hash = (53 * hash) + getTotalShares();
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPrice()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.BuyOffer parseFrom(
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
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.BuyOffer prototype) {
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
   * Protobuf type {@code rs.raf.pds.v5.z2.gRPC.BuyOffer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rs.raf.pds.v5.z2.gRPC.BuyOffer)
      rs.raf.pds.v5.z2.gRPC.BuyOfferOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_BuyOffer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_BuyOffer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.BuyOffer.class, rs.raf.pds.v5.z2.gRPC.BuyOffer.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.BuyOffer.newBuilder()
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
      symbol_ = "";

      totalShares_ = 0;

      price_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_BuyOffer_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.BuyOffer getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.BuyOffer.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.BuyOffer build() {
      rs.raf.pds.v5.z2.gRPC.BuyOffer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.BuyOffer buildPartial() {
      rs.raf.pds.v5.z2.gRPC.BuyOffer result = new rs.raf.pds.v5.z2.gRPC.BuyOffer(this);
      result.symbol_ = symbol_;
      result.totalShares_ = totalShares_;
      result.price_ = price_;
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
      if (other instanceof rs.raf.pds.v5.z2.gRPC.BuyOffer) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.BuyOffer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.BuyOffer other) {
      if (other == rs.raf.pds.v5.z2.gRPC.BuyOffer.getDefaultInstance()) return this;
      if (!other.getSymbol().isEmpty()) {
        symbol_ = other.symbol_;
        onChanged();
      }
      if (other.getTotalShares() != 0) {
        setTotalShares(other.getTotalShares());
      }
      if (other.getPrice() != 0D) {
        setPrice(other.getPrice());
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
      rs.raf.pds.v5.z2.gRPC.BuyOffer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (rs.raf.pds.v5.z2.gRPC.BuyOffer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object symbol_ = "";
    /**
     * <code>string symbol = 1;</code>
     */
    public java.lang.String getSymbol() {
      java.lang.Object ref = symbol_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        symbol_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string symbol = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSymbolBytes() {
      java.lang.Object ref = symbol_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        symbol_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string symbol = 1;</code>
     */
    public Builder setSymbol(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      symbol_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string symbol = 1;</code>
     */
    public Builder clearSymbol() {
      
      symbol_ = getDefaultInstance().getSymbol();
      onChanged();
      return this;
    }
    /**
     * <code>string symbol = 1;</code>
     */
    public Builder setSymbolBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      symbol_ = value;
      onChanged();
      return this;
    }

    private int totalShares_ ;
    /**
     * <code>int32 totalShares = 2;</code>
     */
    public int getTotalShares() {
      return totalShares_;
    }
    /**
     * <code>int32 totalShares = 2;</code>
     */
    public Builder setTotalShares(int value) {
      
      totalShares_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 totalShares = 2;</code>
     */
    public Builder clearTotalShares() {
      
      totalShares_ = 0;
      onChanged();
      return this;
    }

    private double price_ ;
    /**
     * <code>double price = 3;</code>
     */
    public double getPrice() {
      return price_;
    }
    /**
     * <code>double price = 3;</code>
     */
    public Builder setPrice(double value) {
      
      price_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double price = 3;</code>
     */
    public Builder clearPrice() {
      
      price_ = 0D;
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


    // @@protoc_insertion_point(builder_scope:rs.raf.pds.v5.z2.gRPC.BuyOffer)
  }

  // @@protoc_insertion_point(class_scope:rs.raf.pds.v5.z2.gRPC.BuyOffer)
  private static final rs.raf.pds.v5.z2.gRPC.BuyOffer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.BuyOffer();
  }

  public static rs.raf.pds.v5.z2.gRPC.BuyOffer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BuyOffer>
      PARSER = new com.google.protobuf.AbstractParser<BuyOffer>() {
    @java.lang.Override
    public BuyOffer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BuyOffer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BuyOffer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BuyOffer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.BuyOffer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

