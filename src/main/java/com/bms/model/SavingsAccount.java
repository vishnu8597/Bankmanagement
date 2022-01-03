package com.bms.model;

import java.sql.Date;

/**
 * This class maps the object from Accounts table in database, and SavingsAccount implements Account interface.
 * Filename: SavingsAccount.java
 *
 * @author: Namit Prakash Dadlani
 */

public class SavingsAccount implements com.bms.model.Account {

  private int accountId;
  private String accountType;
  private Date accountOpeningDate;
  private String accountEmail;
  private float accountBalance;
  private String accountMiscParams;
  private Date lastVisitDate;

  public SavingsAccount(int accountId, String accountType, Date accountOpeningDate, String accountEmail, float accountBalance, String accountMiscParams, Date lastVisitDate) {
    this.accountId = accountId;
    this.accountType = accountType;
    this.accountOpeningDate = accountOpeningDate;
    this.accountEmail = accountEmail;
    this.accountBalance = accountBalance;
    this.accountMiscParams = accountMiscParams;
    this.lastVisitDate = lastVisitDate;
  }

  public SavingsAccount() {
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Date getAccountOpeningDate() {
    return accountOpeningDate;
  }

  public void setAccountOpeningDate(Date accountOpeningDate) {
    this.accountOpeningDate = accountOpeningDate;
  }

  public String getAccountEmail() {
    return accountEmail;
  }

  public void setAccountEmail(String accountEmail) {
    this.accountEmail = accountEmail;
  }

  public float getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(float accountBalance) {
    this.accountBalance = accountBalance;
  }

  public String getAccountMiscParams() {
    return accountMiscParams;
  }

  public void setAccountMiscParams(String accountMiscParams) {
    this.accountMiscParams = accountMiscParams;
  }

  public String getAccountDetails() {
    return "Savings Account " + accountId + " belongs to " + accountEmail;
  }

  public Date getLastVisitDate() {
    return lastVisitDate;
  }

  public void setLastVisitDate(Date lastVisitDate) {
    this.lastVisitDate = lastVisitDate;
  }
}
