// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * <pre>
 * Struktura koja sadrži informacije o kompaniji
 * </pre>
 *
 * Protobuf type {@code rs.raf.pds.v5.z2.gRPC.Company}
 */
public  final class Company extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rs.raf.pds.v5.z2.gRPC.Company)
    CompanyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Company.newBuilder() to construct.
  private Company(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Company() {
    symbol_ = "";
    name_ = "";
    price_ = 0D;
    change_ = 0D;
    lastPrice_ = 0D;
    oldPrices_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Company(
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
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 25: {

            price_ = input.readDouble();
            break;
          }
          case 33: {

            change_ = input.readDouble();
            break;
          }
          case 42: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (date_ != null) {
              subBuilder = date_.toBuilder();
            }
            date_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(date_);
              date_ = subBuilder.buildPartial();
            }

            break;
          }
          case 49: {

            lastPrice_ = input.readDouble();
            break;
          }
          case 57: {
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
              oldPrices_ = new java.util.ArrayList<java.lang.Double>();
              mutable_bitField0_ |= 0x00000040;
            }
            oldPrices_.add(input.readDouble());
            break;
          }
          case 58: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040) && input.getBytesUntilLimit() > 0) {
              oldPrices_ = new java.util.ArrayList<java.lang.Double>();
              mutable_bitField0_ |= 0x00000040;
            }
            while (input.getBytesUntilLimit() > 0) {
              oldPrices_.add(input.readDouble());
            }
            input.popLimit(limit);
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
      if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
        oldPrices_ = java.util.Collections.unmodifiableList(oldPrices_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_Company_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_Company_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.Company.class, rs.raf.pds.v5.z2.gRPC.Company.Builder.class);
  }

  private int bitField0_;
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

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 2;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRICE_FIELD_NUMBER = 3;
  private double price_;
  /**
   * <code>double price = 3;</code>
   */
  public double getPrice() {
    return price_;
  }

  public static final int CHANGE_FIELD_NUMBER = 4;
  private double change_;
  /**
   * <code>double change = 4;</code>
   */
  public double getChange() {
    return change_;
  }

  public static final int DATE_FIELD_NUMBER = 5;
  private com.google.protobuf.Timestamp date_;
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  public boolean hasDate() {
    return date_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  public com.google.protobuf.Timestamp getDate() {
    return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
  }
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  public com.google.protobuf.TimestampOrBuilder getDateOrBuilder() {
    return getDate();
  }

  public static final int LASTPRICE_FIELD_NUMBER = 6;
  private double lastPrice_;
  /**
   * <code>double lastPrice = 6;</code>
   */
  public double getLastPrice() {
    return lastPrice_;
  }

  public static final int OLDPRICES_FIELD_NUMBER = 7;
  private java.util.List<java.lang.Double> oldPrices_;
  /**
   * <code>repeated double oldPrices = 7;</code>
   */
  public java.util.List<java.lang.Double>
      getOldPricesList() {
    return oldPrices_;
  }
  /**
   * <code>repeated double oldPrices = 7;</code>
   */
  public int getOldPricesCount() {
    return oldPrices_.size();
  }
  /**
   * <code>repeated double oldPrices = 7;</code>
   */
  public double getOldPrices(int index) {
    return oldPrices_.get(index);
  }
  private int oldPricesMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (!getSymbolBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, symbol_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (price_ != 0D) {
      output.writeDouble(3, price_);
    }
    if (change_ != 0D) {
      output.writeDouble(4, change_);
    }
    if (date_ != null) {
      output.writeMessage(5, getDate());
    }
    if (lastPrice_ != 0D) {
      output.writeDouble(6, lastPrice_);
    }
    if (getOldPricesList().size() > 0) {
      output.writeUInt32NoTag(58);
      output.writeUInt32NoTag(oldPricesMemoizedSerializedSize);
    }
    for (int i = 0; i < oldPrices_.size(); i++) {
      output.writeDoubleNoTag(oldPrices_.get(i));
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
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (price_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, price_);
    }
    if (change_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, change_);
    }
    if (date_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getDate());
    }
    if (lastPrice_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(6, lastPrice_);
    }
    {
      int dataSize = 0;
      dataSize = 8 * getOldPricesList().size();
      size += dataSize;
      if (!getOldPricesList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      oldPricesMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.Company)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.Company other = (rs.raf.pds.v5.z2.gRPC.Company) obj;

    boolean result = true;
    result = result && getSymbol()
        .equals(other.getSymbol());
    result = result && getName()
        .equals(other.getName());
    result = result && (
        java.lang.Double.doubleToLongBits(getPrice())
        == java.lang.Double.doubleToLongBits(
            other.getPrice()));
    result = result && (
        java.lang.Double.doubleToLongBits(getChange())
        == java.lang.Double.doubleToLongBits(
            other.getChange()));
    result = result && (hasDate() == other.hasDate());
    if (hasDate()) {
      result = result && getDate()
          .equals(other.getDate());
    }
    result = result && (
        java.lang.Double.doubleToLongBits(getLastPrice())
        == java.lang.Double.doubleToLongBits(
            other.getLastPrice()));
    result = result && getOldPricesList()
        .equals(other.getOldPricesList());
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPrice()));
    hash = (37 * hash) + CHANGE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getChange()));
    if (hasDate()) {
      hash = (37 * hash) + DATE_FIELD_NUMBER;
      hash = (53 * hash) + getDate().hashCode();
    }
    hash = (37 * hash) + LASTPRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLastPrice()));
    if (getOldPricesCount() > 0) {
      hash = (37 * hash) + OLDPRICES_FIELD_NUMBER;
      hash = (53 * hash) + getOldPricesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.Company parseFrom(
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
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.Company prototype) {
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
   * <pre>
   * Struktura koja sadrži informacije o kompaniji
   * </pre>
   *
   * Protobuf type {@code rs.raf.pds.v5.z2.gRPC.Company}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rs.raf.pds.v5.z2.gRPC.Company)
      rs.raf.pds.v5.z2.gRPC.CompanyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_Company_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_Company_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.Company.class, rs.raf.pds.v5.z2.gRPC.Company.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.Company.newBuilder()
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

      name_ = "";

      price_ = 0D;

      change_ = 0D;

      if (dateBuilder_ == null) {
        date_ = null;
      } else {
        date_ = null;
        dateBuilder_ = null;
      }
      lastPrice_ = 0D;

      oldPrices_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.BerzaServiceOuterClass.internal_static_rs_raf_pds_v5_z2_gRPC_Company_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.Company getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.Company.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.Company build() {
      rs.raf.pds.v5.z2.gRPC.Company result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.Company buildPartial() {
      rs.raf.pds.v5.z2.gRPC.Company result = new rs.raf.pds.v5.z2.gRPC.Company(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.symbol_ = symbol_;
      result.name_ = name_;
      result.price_ = price_;
      result.change_ = change_;
      if (dateBuilder_ == null) {
        result.date_ = date_;
      } else {
        result.date_ = dateBuilder_.build();
      }
      result.lastPrice_ = lastPrice_;
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        oldPrices_ = java.util.Collections.unmodifiableList(oldPrices_);
        bitField0_ = (bitField0_ & ~0x00000040);
      }
      result.oldPrices_ = oldPrices_;
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
      if (other instanceof rs.raf.pds.v5.z2.gRPC.Company) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.Company)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.Company other) {
      if (other == rs.raf.pds.v5.z2.gRPC.Company.getDefaultInstance()) return this;
      if (!other.getSymbol().isEmpty()) {
        symbol_ = other.symbol_;
        onChanged();
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getPrice() != 0D) {
        setPrice(other.getPrice());
      }
      if (other.getChange() != 0D) {
        setChange(other.getChange());
      }
      if (other.hasDate()) {
        mergeDate(other.getDate());
      }
      if (other.getLastPrice() != 0D) {
        setLastPrice(other.getLastPrice());
      }
      if (!other.oldPrices_.isEmpty()) {
        if (oldPrices_.isEmpty()) {
          oldPrices_ = other.oldPrices_;
          bitField0_ = (bitField0_ & ~0x00000040);
        } else {
          ensureOldPricesIsMutable();
          oldPrices_.addAll(other.oldPrices_);
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
      rs.raf.pds.v5.z2.gRPC.Company parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (rs.raf.pds.v5.z2.gRPC.Company) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

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

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
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

    private double change_ ;
    /**
     * <code>double change = 4;</code>
     */
    public double getChange() {
      return change_;
    }
    /**
     * <code>double change = 4;</code>
     */
    public Builder setChange(double value) {
      
      change_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double change = 4;</code>
     */
    public Builder clearChange() {
      
      change_ = 0D;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp date_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> dateBuilder_;
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public boolean hasDate() {
      return dateBuilder_ != null || date_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public com.google.protobuf.Timestamp getDate() {
      if (dateBuilder_ == null) {
        return date_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : date_;
      } else {
        return dateBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public Builder setDate(com.google.protobuf.Timestamp value) {
      if (dateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        date_ = value;
        onChanged();
      } else {
        dateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public Builder setDate(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (dateBuilder_ == null) {
        date_ = builderForValue.build();
        onChanged();
      } else {
        dateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public Builder mergeDate(com.google.protobuf.Timestamp value) {
      if (dateBuilder_ == null) {
        if (date_ != null) {
          date_ =
            com.google.protobuf.Timestamp.newBuilder(date_).mergeFrom(value).buildPartial();
        } else {
          date_ = value;
        }
        onChanged();
      } else {
        dateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public Builder clearDate() {
      if (dateBuilder_ == null) {
        date_ = null;
        onChanged();
      } else {
        date_ = null;
        dateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public com.google.protobuf.Timestamp.Builder getDateBuilder() {
      
      onChanged();
      return getDateFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getDateOrBuilder() {
      if (dateBuilder_ != null) {
        return dateBuilder_.getMessageOrBuilder();
      } else {
        return date_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : date_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp date = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getDateFieldBuilder() {
      if (dateBuilder_ == null) {
        dateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getDate(),
                getParentForChildren(),
                isClean());
        date_ = null;
      }
      return dateBuilder_;
    }

    private double lastPrice_ ;
    /**
     * <code>double lastPrice = 6;</code>
     */
    public double getLastPrice() {
      return lastPrice_;
    }
    /**
     * <code>double lastPrice = 6;</code>
     */
    public Builder setLastPrice(double value) {
      
      lastPrice_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double lastPrice = 6;</code>
     */
    public Builder clearLastPrice() {
      
      lastPrice_ = 0D;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Double> oldPrices_ = java.util.Collections.emptyList();
    private void ensureOldPricesIsMutable() {
      if (!((bitField0_ & 0x00000040) == 0x00000040)) {
        oldPrices_ = new java.util.ArrayList<java.lang.Double>(oldPrices_);
        bitField0_ |= 0x00000040;
       }
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public java.util.List<java.lang.Double>
        getOldPricesList() {
      return java.util.Collections.unmodifiableList(oldPrices_);
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public int getOldPricesCount() {
      return oldPrices_.size();
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public double getOldPrices(int index) {
      return oldPrices_.get(index);
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public Builder setOldPrices(
        int index, double value) {
      ensureOldPricesIsMutable();
      oldPrices_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public Builder addOldPrices(double value) {
      ensureOldPricesIsMutable();
      oldPrices_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public Builder addAllOldPrices(
        java.lang.Iterable<? extends java.lang.Double> values) {
      ensureOldPricesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, oldPrices_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated double oldPrices = 7;</code>
     */
    public Builder clearOldPrices() {
      oldPrices_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
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


    // @@protoc_insertion_point(builder_scope:rs.raf.pds.v5.z2.gRPC.Company)
  }

  // @@protoc_insertion_point(class_scope:rs.raf.pds.v5.z2.gRPC.Company)
  private static final rs.raf.pds.v5.z2.gRPC.Company DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.Company();
  }

  public static rs.raf.pds.v5.z2.gRPC.Company getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Company>
      PARSER = new com.google.protobuf.AbstractParser<Company>() {
    @java.lang.Override
    public Company parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Company(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Company> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Company> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.Company getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
