package com.bms.dao;

import com.bms.model.TransactionDisplay;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * This class manages the database operations related to viewing of Transaction History of the customer.
 * Filename: TransactionHistoryDao.java
 *
 * @author: Namit Prakash Dadlani
 */

public class TransactionHistoryDao implements ITransactionHistoryDao {

  final String DB_URL = "jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_3_DEVINT";
  final String DB_USER = "CSCI5308_3_DEVINT_USER";
  final String DB_PWD = "9nEWerA7YdR";
  private final JdbcTemplate jdbcTemplate;
  private Connection connection;
  private PreparedStatement statement;

  public TransactionHistoryDao() {
    this.jdbcTemplate = new JdbcTemplate(getDataSource());
  }

  public DataSource getDataSource() {
    DataSource dataSource = new DriverManagerDataSource(DB_URL, DB_USER, DB_PWD);
    return dataSource;
  }

  public List<TransactionDisplay> fetchAllTransactionHistory(String emailId) {
    List<TransactionDisplay> fetchedTransactionList = null;
    try {
      fetchedTransactionList = jdbcTemplate.query("SELECT * FROM transactions WHERE EMAIL = ? ORDER BY TIMESTAMP DESC",
              (rs, rowNum) -> {
                return new TransactionDisplay(Integer.parseInt(rs.getString("id")),
                        //new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new DateTime(rs.getLong("timestamp"))),
                        DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(new DateTime(rs.getLong("timestamp"))),
                        rs.getBigDecimal("amount"), rs.getString("mode"),
                        rs.getBigDecimal("balance"));
              }, emailId);
      jdbcTemplate.getDataSource().getConnection().close();
    } catch (DataAccessException | SQLException e) {
      e.printStackTrace();
    }
    return fetchedTransactionList;
  }

  public List<TransactionDisplay> fetchWithinRangeTransactionHistory(String emailId, DateTime beginDate, DateTime endDate) {
    List<TransactionDisplay> fetchedTransactionList = null;
    try {
      fetchedTransactionList = jdbcTemplate.query("SELECT * FROM transactions WHERE email = ? AND timestamp >= ? AND timestamp <= ? ORDER BY TIMESTAMP DESC",
              (rs, rowNum) -> {
                return new TransactionDisplay(Integer.parseInt(rs.getString("id")),
                        //new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new DateTime(rs.getLong("timestamp"))),
                        DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(new DateTime(rs.getLong("timestamp"))),
                        rs.getBigDecimal("amount"), rs.getString("mode"),
                        rs.getBigDecimal("balance"));
              }, emailId, beginDate.getMillis(), endDate.getMillis());
      jdbcTemplate.getDataSource().getConnection().close();
    } catch (DataAccessException e) {
      e.printStackTrace();
      throw e;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return fetchedTransactionList;
  }
}
