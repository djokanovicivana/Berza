// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: berza_service.proto

package rs.raf.pds.v5.z2.gRPC;

public interface CompanyRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rs.raf.pds.v5.z2.gRPC.CompanyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string ClientId = 1;</code>
   */
  java.lang.String getClientId();
  /**
   * <code>string ClientId = 1;</code>
   */
  com.google.protobuf.ByteString
      getClientIdBytes();

  /**
   * <code>repeated string Symbols = 2;</code>
   */
  java.util.List<java.lang.String>
      getSymbolsList();
  /**
   * <code>repeated string Symbols = 2;</code>
   */
  int getSymbolsCount();
  /**
   * <code>repeated string Symbols = 2;</code>
   */
  java.lang.String getSymbols(int index);
  /**
   * <code>repeated string Symbols = 2;</code>
   */
  com.google.protobuf.ByteString
      getSymbolsBytes(int index);
}
