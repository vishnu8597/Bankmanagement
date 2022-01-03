package com.bms.model;

public class FetchAddressDetails {

  private String address;
  private String password;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "FetchAddressDetails{" +
            "address='" + address + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
