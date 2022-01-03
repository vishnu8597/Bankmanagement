package com.bms.model;

/**
 * ENUM of transaction mode
 * Filename : Mode.java
 *
 * @author: Anjali Chaudhary
 */
public enum Mode {
  CREDIT("credit"), DEBIT("debit");

  String mode;

  Mode(String value) {
    this.mode = value;
  }

  public static Mode getEnum(String value) {
    for (Mode v : values()) {
      if (v.getValue().equalsIgnoreCase(value)) {
        return v;
      }
    }
    throw new IllegalArgumentException();
  }

  public String getValue() {
    return mode;
  }

  @Override
  public String toString() {
    return this.getValue();
  }

}
