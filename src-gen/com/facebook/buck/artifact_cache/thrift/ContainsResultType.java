/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.artifact_cache.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)")
public enum ContainsResultType implements org.apache.thrift.TEnum {
  CONTAINS(0),
  DOES_NOT_CONTAIN(1),
  UNKNOWN_DUE_TO_TRANSIENT_ERRORS(2);

  private final int value;

  private ContainsResultType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static ContainsResultType findByValue(int value) { 
    switch (value) {
      case 0:
        return CONTAINS;
      case 1:
        return DOES_NOT_CONTAIN;
      case 2:
        return UNKNOWN_DUE_TO_TRANSIENT_ERRORS;
      default:
        return null;
    }
  }
}
