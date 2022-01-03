package com.bms.model;

public class FetchDeleteAccountDetails {

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "FetchDeleteAccountDetails{" +
            "password='" + password + '\'' +
            '}';
  }
}
