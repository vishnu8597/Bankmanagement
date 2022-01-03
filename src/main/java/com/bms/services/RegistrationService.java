package com.bms.services;

import com.bms.dao.RegistrationDao;
import com.bms.model.Customer;
import com.bms.model.FetchUserDetails;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Purpose of this class is to hold the business logic for the registration functionality
 * Filename: RegistrationService.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public class RegistrationService implements IRegistrationService {

  private final RegistrationDao registrationDao;

  @Autowired
  public RegistrationService() {
    this.registrationDao = new RegistrationDao();
  }

  /*
   * Purpose of this method is to verify whether the E-mail of the user is already registered
   */
  public boolean verifyEmail(FetchUserDetails fetchUserDetails) {
    List<Customer> response = registrationDao.selectRow(fetchUserDetails);
    if (response.size() != 0) {
      for (Customer row : response) {
        return row.getEmail().equals(fetchUserDetails.getEmail());
      }

    }
    return false;
  }
}