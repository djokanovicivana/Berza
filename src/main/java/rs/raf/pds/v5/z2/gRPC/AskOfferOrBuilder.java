// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

public interface AskOfferOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rs.raf.pds.v5.z2.gRPC.AskOffer)
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
   * <code>int32 price = 2;</code>
   */
  int getPrice();

  /**
   * <code>int32 numberOfOffers = 3;</code>
   */
  int getNumberOfOffers();

  /**
   * <code>string clientId = 4;</code>
   */
  java.lang.String getClientId();
  /**
   * <code>string clientId = 4;</code>
   */
  com.google.protobuf.ByteString
      getClientIdBytes();
}