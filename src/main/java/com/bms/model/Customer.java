package com.bms.model;

/**
 * Purpose of this class is to function as a model for the customer details
 * Filename: Customer.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public class Customer {

  private String email;
  private String userName;
  private String firstName;
  private String lastName;
  private String address;
  private String password;

  public Customer(String email, String userName, String firstName, String lastName, String address, String password) {
    this.email = email;
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.password = password;
  }

  public Customer() {

  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

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
    return "Customer{" +
            "email='" + email + '\'' +
            ", userName='" + userName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}