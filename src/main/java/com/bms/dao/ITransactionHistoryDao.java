package com.bms.dao;

import com.bms.model.TransactionDisplay;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Purpose of this interface is to create abstract methods for the TransactionHistoryDao class
 * Filename: ITransactionHistoryDao.java
 *
 * @author: Namit Prakash Dadlani
 */

public interface ITransactionHistoryDao {

  List<TransactionDisplay> fetchAllTransactionHistory(String emailId);

  List<TransactionDisplay> fetchWithinRangeTransactionHistory(String emailId, DateTime beginDate, DateTime endDate);

}
