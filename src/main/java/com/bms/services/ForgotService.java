package com.bms.services;

import com.bms.dao.ForgotDAO;
import com.bms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 *This class mainly deals with forgot password operation for the user
 * @author Jainesh Ketan Desai
 */
@Service
public class ForgotService implements IForgotService {

  @Autowired
  ForgotDAO forgotDAO;

  /*
   * this function gives customer row where email is matched
   * @param name: passes Email in the parameter
   * @return returns all rows where email matches
   */
  @Override
  public List<Customer> findByName(String name) {

    return forgotDAO.findByName(name);
  }

  /*
   * this methods update password for the given email
   * @param customer: passes customer object in update method
   * @throws SQLException
   */
  @Override
  public Boolean update(Customer customer) throws SQLException {

    return forgotDAO.update(customer);

  }
}



