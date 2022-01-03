package com.bms.dao;

import com.bms.model.Transaction;

import java.util.List;

public interface ITransactionDAO {

  /**
   * Purpose of this interface is to implement the abstract methods for the ITransactionDAO class
   * Filename: ITransactionDAO.java
   *
   * @author: Anjali Chaudhary
   */

  Transaction createTransaction(Transaction transaction);

  List<Transaction> getRecentTransaction(String emailId);

}
