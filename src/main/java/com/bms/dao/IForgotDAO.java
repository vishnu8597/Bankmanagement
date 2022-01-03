package com.bms.dao;

import com.bms.model.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Purpose of this interface is to create abstract methods for the ForgotDAO class
 * Filename: IForgotDAO.java
 *
 * @author: Jainesh Ketan Desai
 */
public interface IForgotDAO {

  /*
   * this function gives customer row where email is matched
   * @param name: passes Email in the parameter
   * @return returns all rows where email matches
   */
  List<Customer> findByName(String name);

  /*
   * this methods update password for the given email
   * @param customer: passes customer object in update method
   * @throws SQLException
   */
  Boolean update(Customer customer) throws SQLException;
}
