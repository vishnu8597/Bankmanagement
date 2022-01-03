package com.bms.model;

public class FetchEmailDetails {


  private String newemail;
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNewemail() {
    return newemail;
  }

  public void setNewemail(String newemail) {
    this.newemail = newemail;
  }

  @Override
  public String toString() {
    return "FetchEmailDetails{" +
            "newemail='" + newemail + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
