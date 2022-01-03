package com.bms.model;

import java.math.BigDecimal;

/**
 * This class contains only the attributes of a transaction which is to be displayed on Transaction History page.
 * Filename: TransactionDisplay.java
 *
 * @author: Namit Prakash Dadlani
 */


public class TransactionDisplay {

  private int id;
  private String transactionTimestamp;
  private BigDecimal amount;
  private String mode;
  private BigDecimal balance;

  public TransactionDisplay() {

  }

  public TransactionDisplay(int id, String transactionTimestamp, BigDecimal amount, String mode, BigDecimal balance) {
    this.id = id;
    this.transactionTimestamp = transactionTimestamp;
    this.amount = amount;
    this.mode = mode;
    this.balance = balance;
  }

  public String printTransactionItem() {
    return "id:" + this.id
            + "\ttime:" + this.transactionTimestamp
            + "\tamount:" + this.amount
            + "\tmode" + this.mode
            + "\tbalance" + this.balance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTransactionTimestamp() {
    return transactionTimestamp;
  }

  public void setTransactionTimestamp(String transactionTimestamp) {
    this.transactionTimestamp = transactionTimestamp;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
