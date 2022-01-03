package com.bms.services;

import com.bms.model.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 *Purpose of this interface is to create abstract methods for the
 * ForgotService class
 *Filename: IForgotService.java
 *
 * @author: Jainesh Ketan Desai
 */
public interface IForgotService {

  List<Customer> findByName(String name);

  Boolean update(Customer customer) throws SQLException;
}
