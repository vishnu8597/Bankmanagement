package com.bms.services;

import com.bms.dao.ILoginDao;
import com.bms.dao.LoginDao;
import com.bms.model.Customer;
import com.bms.model.UserLoginDetails;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Purpose of this class is to hold the business logic for handling the login functionality
 * Filename: LoginService.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public class LoginService implements ILoginService {

  private final ILoginDao loginDao;

  @Autowired
  public LoginService() {
    this.loginDao = new LoginDao();
  }

  /*
   * Purpose of this method is to check if the E-mail is correctly entered
   */
  public boolean verifyEmail(UserLoginDetails userLoginDetails) {
    List<Customer> resultSet = loginDao.verifyDetails(userLoginDetails);
    if (resultSet.size() != 0) {
      for (Customer email : resultSet) {
        return email.getEmail().equals(userLoginDetails.getEmail());
      }
    }
    return false;
  }

  /*
   * Purpose of this method is to verify the password
   */
  public boolean verifyPassword(UserLoginDetails userLoginDetails) {
    List<Customer> resultSet = loginDao.verifyDetails(userLoginDetails);
    if (resultSet.size() != 0) {
      for (Customer password : resultSet) {
        return password.getPassword().equals(userLoginDetails.getPassword());
      }
    }
    return false;
  }
}