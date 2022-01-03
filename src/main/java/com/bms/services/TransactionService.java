package com.bms.services;

import com.bms.dao.ITransactionDAO;
import com.bms.model.Transaction;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * The purpose of this service method is to manage Account Transactions
 * Filename : TransactionService.java
 *
 * @author: Anjali Chaudhary
 */
@Service
public class TransactionService implements ITransactionService {

  private final ITransactionDAO transactionDAO;
  private final HttpSession httpSession;

  @Autowired
  public TransactionService(ITransactionDAO transactionDAO, HttpSession httpSession) {
    this.transactionDAO = transactionDAO;
    this.httpSession = httpSession;
  }

  /**
   * Generate random number of length 12
   *
   * @return random number
   */
  public static String generateRandom() {
    int length = 12;
    Random random = new Random();
    char[] digits = new char[length];
    digits[0] = (char) (random.nextInt(9) + '1');
    for (int i = 1; i < length; i++) {
      digits[i] = (char) (random.nextInt(10) + '0');
    }
    return new String(digits);
  }

  /**
   * Create transaction record
   *
   * @return the transaction data
   */
  @Override
  public Transaction createTransaction(DateTime transactionTimeStamp, String description, String refNumber,
                                       float amount, String mode, float balance, String fromAccountNumber, String toAccountNumber,
                                       String emailId) {
    return transactionDAO.createTransaction(new Transaction(0, transactionTimeStamp, description, refNumber,
            new BigDecimal(amount), mode, new BigDecimal(balance), fromAccountNumber, toAccountNumber, emailId));
  }

  /**
   * Get last 5 transactions of logged in user
   *
   * @return list of last 5 transactions
   */
  @Override
  public List<Transaction> getRecentTransaction() {
    return transactionDAO.getRecentTransaction(httpSession.getAttribute("username").toString());
  }
}
