package com.bms.services;


import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.Customer;

import java.sql.SQLException;
import java.util.List;


/**
 * Purpose of this class is to check if the new mail is not already registered
 * and if the entered password is right
 * Filename: CheckCredentialsService.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

public class CheckCredentialsService implements ICheckCredentialsService {

  private String newEmail;
  private String email;
  private final IAccountUpdateDao accountUpadateDao = new AccountUpadateDao();

  /**
   * Checks if the new email is registered or not
   * Parameters:
   * email - newemail that fetches the row
   * Returns:
   * true - if the new email is not registered
   * false - if the new email is registered
   */
  public boolean checkNewEmail(String newemail) throws SQLException {
    List<Customer> resultSet = accountUpadateDao.select(newemail);
    if (resultSet.size() == 0) {
      return true;
    }
      return resultSet.size() <= 0;
  }

  /**
   * Checks if the password entered is right
   * Parameters:
   * email - newemail that fetches the row
   * password - password of the account
   * Returns:
   * true - if password entered is right
   * false - if password entered is wrong
   */
  public boolean checkPassword(String password, String email) throws SQLException {
    List<Customer> resultSet = accountUpadateDao.select(email);
    for (Customer customer : resultSet) {
      return customer.getPassword().equals(password);
    }
    return true;
  }
}