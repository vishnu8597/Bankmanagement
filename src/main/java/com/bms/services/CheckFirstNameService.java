package com.bms.services;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CheckFirstNameService implements ICheckFirstNameService {

  private final IAccountUpdateDao accountUpadateDao = new AccountUpadateDao();

  /**
   * Checks if the new name is in use or not
   * Parameters:
   * firstName = first name the user enters
   * email - email that fetches the row
   * Returns:
   * true - if the new name is already in use
   * false - if the new name if new address is not in use
   */
  public boolean CheckFirstName(String firstName, String email) throws SQLException {
    List<Customer> resultSet = accountUpadateDao.select(email);
    for (Customer fname : resultSet) {
      return fname.getFirstName().equals(firstName);
    }

    return true;
  }
}