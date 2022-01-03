package com.bms.model;

/**
 * Purpose of this class is to function as a model to retrieve Branch details
 * Filename: BranchSearchDetails.java
 *
 * @author: Anish Devineni
 */

public class BranchSearchDetails {

  private String branchname;
  private String ifsccode;

  @Override
  public String toString() {
    return "BranchSearchDetails{" +
            "branchname='" + branchname + '\'' +
            ", ifsccode='" + ifsccode + '\'' +
            '}';
  }

  public String getBranchname() {
    return branchname;
  }

  public void setBranchname(String branchname) {
    this.branchname = branchname;
  }

  public String getIfsccode() {
    return ifsccode;
  }

  public void setIfsccode(String ifsccode) {
    this.ifsccode = ifsccode;
  }
}
