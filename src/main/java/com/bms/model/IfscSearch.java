package com.bms.model;

/**
 * Purpose of this class is to function as a model to obtain IFSC details
 * Filename: IfscSearch.java
 *
 * @author: Anish Devineni
 */

public class IfscSearch {

  private String ifsccode;

  @Override
  public String toString() {
    return "IfscSearch{" +
            "ifsccode='" + ifsccode + '\'' +
            '}';
  }

  public String getIfsccode() {
    return ifsccode;
  }

  public void setIfsccode(String ifsccode) {
    this.ifsccode = ifsccode;
  }
}