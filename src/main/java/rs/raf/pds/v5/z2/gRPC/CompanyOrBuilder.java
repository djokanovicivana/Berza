// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

public interface CompanyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rs.raf.pds.v5.z2.gRPC.Company)
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
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>double price = 3;</code>
   */
  double getPrice();

  /**
   * <code>double change = 4;</code>
   */
  double getChange();

  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  boolean hasDate();
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  com.google.protobuf.Timestamp getDate();
  /**
   * <code>.google.protobuf.Timestamp date = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDateOrBuilder();

  /**
   * <code>double lastPrice = 6;</code>
   */
  double getLastPrice();

  /**
   * <code>repeated double oldPrices = 7;</code>
   */
  java.util.List<java.lang.Double> getOldPricesList();
  /**
   * <code>repeated double oldPrices = 7;</code>
   */
  int getOldPricesCount();
  /**
   * <code>repeated double oldPrices = 7;</code>
   */
  double getOldPrices(int index);
}
