package com.bms.model;

/**
 * Purpose of this class is to function as a model to fetch branch details
 * Filename: BranchSearch.java
 *
 * @author: Anish Devineni
 */

public class BranchSearch {

  private String branchname;
  private String ifsc;
  private String address;
  private String phonenumber;

  public BranchSearch(String branchname, String ifsc, String address, String phonenumber) {

    this.branchname = branchname;
    this.ifsc = ifsc;
    this.address = address;
    this.phonenumber = phonenumber;
  }

  @Override
  public String toString() {
    return "BranchSearch{" +
            "branchname='" + branchname + '\'' +
            ", ifsc='" + ifsc + '\'' +
            ", address='" + address + '\'' +
            ", phonenumber=" + phonenumber +
            '}';
  }

  public String getBranchname() {
    return branchname;
  }

  public void setBranchname(String branchname) {
    this.branchname = branchname;
  }

  public String getIfsc() {
    return ifsc;
  }

  public void setIfsc(String ifsc) {
    this.ifsc = ifsc;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }
}
