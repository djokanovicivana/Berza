// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

public interface SellOrderRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rs.raf.pds.v5.z2.gRPC.SellOrderRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string symbol = 1;</code>
   */
  java.lang.String getSymbol();
  /**
   * <code>string symbol = 1;</code>
   */
  com.google.protobuf.ByteString
      getSymbolBytes();

  /**
   * <code>double price = 2;</code>
   */
  double getPrice();

  /**
   * <code>int32 numberOfShares = 3;</code>
   */
  int getNumberOfShares();
}