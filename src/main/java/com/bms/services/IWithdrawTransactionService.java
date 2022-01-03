package com.bms.services;

import com.bms.model.SavingsAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Purpose of this interface is to create abstract methods for the WithdrawTransactionService class
 * Filename: IWithdrawTransactionService.java
 *
 * @author: Jainesh Ketan Desai
 */

public interface IWithdrawTransactionService {

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

  /*
   *
   * @param name: name parameter takes email address as a parameter in method
   * @return: this method return list of user by name
   */
  List<SavingsAccount> findByName(String name);

  /*
   * @param accountModel: takes object of SavingAccount
   * @param amount: amount is the amount entered by user from the frontend
   * @return: this method insert into database and does the withdraw
   *  transactionality
   * @throws SQLException
   */
  Boolean update(SavingsAccount accountModel, int amount) throws SQLException;
}
