package com.bms.model;

/**
 * Purpose of this class is to function as a model for the user login details
 * Filename: UserLoginDetails.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public class UserLoginDetails {

  private String email;
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserLoginDetails{" +
            "email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}