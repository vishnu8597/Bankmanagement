package com.bms.dao;

import com.bms.model.SavingsAccount;

import java.sql.SQLException;
import java.util.List;

/**
 * Purpose of this interface is to create abstract methods for the WithdrawTransactionDAO class
 * Filename: IWithdrawTransactionDAO.java
 *
 * @author: Jainesh Ketan Desai
 */
public interface IWithdrawTransactionDAO {

  /*this method return list of user by name
   * @param name: passes name for the given entry
   * @return: method return list of user by name
   */
  List<SavingsAccount> findByName(String name);

  /*
   *this method insert into database and does the withdraw transactionality
   * @param accountModel: it passes object of accountmodel
   * @param amount: paases the value entered by user
   * @return: returns boolean true or false
   * @throws SQLException
   */
  Boolean update(SavingsAccount accountModel, int amount) throws SQLException;
}
