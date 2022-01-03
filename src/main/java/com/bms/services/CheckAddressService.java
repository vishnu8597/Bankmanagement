package com.bms.services;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.Customer;
import com.bms.model.FetchAddressDetails;

import java.sql.SQLException;
import java.util.List;

public class CheckAddressService implements ICheckAddressService {

  private final FetchAddressDetails fetchAddressDetails = new FetchAddressDetails();
  private final IAccountUpdateDao accountUpadateDao = new AccountUpadateDao();


  /**
   * Checks if the new Address is in use or not
   * Parameters:
   * address = address user enters
   * email - email that fetches the row
   * Returns:
   * true - if the new address is already in use
   * false - if the new address if new address is not in use
   */
  public boolean CheckAddress(String address, String email) throws SQLException {
    List<Customer> resultSet = accountUpadateDao.select(email);
    for (Customer add : resultSet) {
      return add.getAddress().equals(address);
    }

    return true;
  }
}