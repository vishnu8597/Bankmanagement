package com.bms.services;

import com.bms.model.Transaction;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Purpose of this interface is to implement abstract methods for ITransactionService class
 * Filename: ITransactionService.java
 *
 * @author: Anjali Chaudhary
 */

public interface ITransactionService {

  Transaction createTransaction(DateTime transactionTimeStamp, String description, String refNumber,
								float amount, String mode, float balance, String fromAccountNumber, String toAccountNumber,
								String emailId);

  List<Transaction> getRecentTransaction();
}
