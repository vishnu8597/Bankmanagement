package com.bms.model;

public class FetchLastName {

  private String lastname;
  private String password;

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "FetchLastName{" +
            "lastname='" + lastname + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
