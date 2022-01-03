package com.bms.dao;

import com.bms.model.SavingsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Deposit Dao class to manage database for the Deposit transactions
 * Filename: DepositDAO.java
 *
 * @author: Anjali Chaudhary
 */
@Repository
public class DepositDAO implements IDepositDAO {

  private static final String GET_ACCOUNT_BY_EMAIL_QUERY = "SELECT * FROM ACCOUNTS WHERE EMAIL = ?";
  private static final String UPDATE_ACCOUNT_QUERY = "UPDATE ACCOUNTS SET ACCOUNT_BAL = ? WHERE EMAIL=?";
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public DepositDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Update account
   *
   * @return updated account
   */
  @Override
  public SavingsAccount updateAccount(SavingsAccount account) {
    jdbcTemplate.update(UPDATE_ACCOUNT_QUERY, account.getAccountBalance(), account.getAccountEmail());
    return account;
  }

  /**
   * Get account detail by email id
   *
   * @return account
   */
  @Override
  public SavingsAccount findAccountDetailsByEmail(String email) {
    try {
      return jdbcTemplate.queryForObject(GET_ACCOUNT_BY_EMAIL_QUERY, (rs, rowNum) -> {
        return new SavingsAccount(
                Integer.parseInt(rs.getString("ACCOUNT_ID")),
                rs.getString("ACCOUNT_TYPE"),
                rs.getDate("OPENING_DATE"),
                rs.getString("EMAIL"),
                rs.getFloat("ACCOUNT_BAL"),
                rs.getString("MISC_PARAMS"),
                rs.getDate("LAST_VISIT_DATE"));
      }, email);
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

}
