package com.bms.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Purpose of this class is to function as a model for the transaction details of deposit
 * Filename: Transaction.java
 *
 * @author: Anjali Chaudhary
 */
public class Transaction {

  private int id;

  private DateTime transactionTimeStamp;

  private String description;

  private String refNumber;

  private BigDecimal amount;

  private String mode;

  private BigDecimal balance;

  private String fromAccountNumber;

  private String toAccountNumber;

  private String emailId;

  public Transaction() {

  }

  public Transaction(int id, DateTime transactionTimeStamp, String description, String refNumber, BigDecimal amount,
                     String mode, BigDecimal balance, String fromAccountNumber, String toAccountNumber, String emailId) {
    this.id = id;
    this.transactionTimeStamp = transactionTimeStamp;
    this.description = description;
    this.refNumber = refNumber;
    this.amount = amount;
    this.mode = mode;
    this.balance = balance;
    this.fromAccountNumber = fromAccountNumber;
    this.toAccountNumber = toAccountNumber;
    this.emailId = emailId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public DateTime getTransactionTimeStamp() {
    return transactionTimeStamp;
  }

  public void setTransactionTimeStamp(DateTime transactionTimeStamp) {
    this.transactionTimeStamp = transactionTimeStamp;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRefNumber() {
    return refNumber;
  }

  public void setRefNumber(String refNumber) {
    this.refNumber = refNumber;
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

  public String getFromAccountNumber() {
    return fromAccountNumber;
  }

  public void setFromAccountNumber(String fromAccountNumber) {
    this.fromAccountNumber = fromAccountNumber;
  }

  public String getToAccountNumber() {
    return toAccountNumber;
  }

  public void setToAccountNumber(String toAccountNumber) {
    this.toAccountNumber = toAccountNumber;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((balance == null) ? 0 : balance.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
    result = prime * result + ((fromAccountNumber == null) ? 0 : fromAccountNumber.hashCode());
    result = prime * result + id;
    result = prime * result + ((mode == null) ? 0 : mode.hashCode());
    result = prime * result + ((refNumber == null) ? 0 : refNumber.hashCode());
    result = prime * result + ((toAccountNumber == null) ? 0 : toAccountNumber.hashCode());
    result = prime * result + ((transactionTimeStamp == null) ? 0 : transactionTimeStamp.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
	  if (this == obj) {
		  return true;
	  }
	  if (obj == null) {
		  return false;
	  }
	  if (getClass() != obj.getClass()) {
		  return false;
	  }
    Transaction other = (Transaction) obj;
    if (amount == null) {
		if (other.amount != null) {
			return false;
		}
    } else if (!amount.equals(other.amount)) {
		return false;
	}
    if (balance == null) {
		if (other.balance != null) {
			return false;
		}
    } else if (!balance.equals(other.balance)) {
		return false;
	}
    if (description == null) {
		if (other.description != null) {
			return false;
		}
    } else if (!description.equals(other.description)) {
		return false;
	}
    if (emailId == null) {
		if (other.emailId != null) {
			return false;
		}
    } else if (!emailId.equals(other.emailId)) {
		return false;
	}
    if (fromAccountNumber == null) {
		if (other.fromAccountNumber != null) {
			return false;
		}
    } else if (!fromAccountNumber.equals(other.fromAccountNumber)) {
		return false;
	}
	  if (id != other.id) {
		  return false;
	  }
    if (mode == null) {
		if (other.mode != null) {
			return false;
		}
    } else if (!mode.equals(other.mode)) {
		return false;
	}
    if (refNumber == null) {
		if (other.refNumber != null) {
			return false;
		}
    } else if (!refNumber.equals(other.refNumber)) {
		return false;
	}
    if (toAccountNumber == null) {
		if (other.toAccountNumber != null) {
			return false;
		}
    } else if (!toAccountNumber.equals(other.toAccountNumber)) {
		return false;
	}
    if (transactionTimeStamp == null) {
		return other.transactionTimeStamp == null;
    } else return transactionTimeStamp.equals(other.transactionTimeStamp);
  }

  @Override
  public String toString() {
    return "Transaction [id=" + id + ", transactionTimeStamp=" + transactionTimeStamp + ", description="
            + description + ", refNumber=" + refNumber + ", amount=" + amount + ", mode=" + mode + ", balance="
            + balance + ", fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber
            + ", emailId=" + emailId + "]";
  }

}
