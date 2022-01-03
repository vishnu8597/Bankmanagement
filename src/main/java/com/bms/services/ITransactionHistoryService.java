package com.bms.services;

import com.bms.model.TransactionDisplay;
import org.joda.time.DateTime;

import java.util.List;

/**
 * This is an interface for Transaction History logic.
 * Filename: ITransactionHistoryService.java
 *
 * @author: Namit Prakash Dadlani
 */

public interface ITransactionHistoryService {

  List<TransactionDisplay> showAllTransactionHistory(String username);

  List<TransactionDisplay> showWithinRangeTransactionHistory(String username, DateTime beginDate, DateTime endDate);

  String fetchNameForTransactionHistory(String email);

  String findHighestTransactions(List<TransactionDisplay> displayTransactions);
}
