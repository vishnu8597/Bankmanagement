package com.bms.dao;

import com.bms.model.SavingsAccount;

import java.sql.*;

/**
 * Purpose of this class is to interact with database to setup and display account details after Log In.
 * Filename: AccountDao.java
 *
 * @author: Namit Prakash Dadlani
 */

public class AccountDao implements IAccountDao {

  final String DB_URL = "jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_3_DEVINT";
  final String DB_USER = "CSCI5308_3_DEVINT_USER";
  final String DB_PWD = "9nEWerA7YdR";
  private Connection connection;
  private PreparedStatement statement;

  public AccountDao() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  public int findAccountIdByEmail(String username) {
    try {
      statement = connection.prepareStatement("SELECT ACCOUNT_ID FROM ACCOUNTS WHERE EMAIL = ? ");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        return resultSet.getInt(1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return -1;
  }

  public SavingsAccount findAccountDetailsByEmail(String username) {
    SavingsAccount currentSavingsAccount = new SavingsAccount();
    currentSavingsAccount.setAccountId(-1);
    try {
      statement = connection.prepareStatement("SELECT * FROM ACCOUNTS WHERE EMAIL = ? ");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        currentSavingsAccount.setAccountId(resultSet.getInt(1));
        currentSavingsAccount.setAccountType(resultSet.getString(2));
        currentSavingsAccount.setAccountEmail(username);
        currentSavingsAccount.setAccountBalance(resultSet.getFloat(6));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return currentSavingsAccount;
  }

  public boolean insertNewAccount(SavingsAccount newSavingsSavingsAccount) {
    int rowsInserted = 0;
    try {
      statement = connection.prepareStatement("INSERT INTO ACCOUNTS VALUES (?,?,?,?,?,?,?) ");
      statement.setInt(1, newSavingsSavingsAccount.getAccountId());
      statement.setString(2, newSavingsSavingsAccount.getAccountType());
      statement.setDate(3, newSavingsSavingsAccount.getAccountOpeningDate());
      statement.setString(4, newSavingsSavingsAccount.getAccountEmail());
      statement.setString(5, newSavingsSavingsAccount.getAccountMiscParams());
      statement.setFloat(6, newSavingsSavingsAccount.getAccountBalance());
      statement.setNull(7, Types.DATE);
      rowsInserted = statement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return rowsInserted != 0;
  }

  @Override
  public int findHighestAccountNum() {
    try {
      statement = connection.prepareStatement("SELECT MAX(ACCOUNT_ID) FROM ACCOUNTS");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        return resultSet.getInt(1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return -1;
  }

  public void closeAccountConnection() {
    try {
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}