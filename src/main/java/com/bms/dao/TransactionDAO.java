package com.bms.dao;

import com.bms.model.Transaction;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Transaction DAO class to manage database for transactions
 * Filename : TransactionDAO.java
 *
 * @author: Anjali Chaudhary
 */

@Repository
public class TransactionDAO implements ITransactionDAO {

  private static final String CREATE_TRANSACTION_QUERY = "INSERT INTO transactions(id, timestamp, description, ref_num, amount, mode, balance, from_account_number, to_account_number, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String GET_RECENT_ACCOUNT_TRANSACTION_QUERY = "SELECT * FROM transactions where email = ? order by timestamp desc limit 5";
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public TransactionDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Create transaction record
   *
   * @return transaction data
   */
  @Override
  public Transaction createTransaction(Transaction transaction) {
    jdbcTemplate.update(CREATE_TRANSACTION_QUERY, transaction.getId(),
            transaction.getTransactionTimeStamp().getMillis(), transaction.getDescription(),
            transaction.getRefNumber(), transaction.getAmount(), transaction.getMode(), transaction.getBalance(),
            transaction.getFromAccountNumber(), transaction.getToAccountNumber(), transaction.getEmailId());
    return transaction;
  }

  /**
   * Get recent transaction (last 5) of user
   *
   * @return list of recent transactions data
   */
  @Override
  public List<Transaction> getRecentTransaction(String emailId) {
    return jdbcTemplate.query(GET_RECENT_ACCOUNT_TRANSACTION_QUERY, (rs, rowNum) -> {

      return new Transaction(Integer.parseInt(rs.getString("id")), new DateTime(rs.getLong("timestamp")),
              rs.getString("description"), rs.getString("ref_num"), rs.getBigDecimal("amount"),
              rs.getString("mode"), rs.getBigDecimal("balance"), rs.getString("from_account_number"),
              rs.getString("to_account_number"), rs.getString("email"));
    }, emailId);
  }

}