package com.bms.model;

public class FetchFirstName {

  private String firstname;
  private String password;

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "FetchFirstName{" +
            "firstname='" + firstname + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
