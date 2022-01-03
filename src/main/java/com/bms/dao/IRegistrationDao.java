package com.bms.dao;

import com.bms.model.Customer;
import com.bms.model.FetchUserDetails;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Purpose of this interface is to create abstract methods for the RegistrationDao class
 * Filename: IRegistrationDao.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public interface IRegistrationDao {

  DataSource getDataSource();

  void insertDetails(FetchUserDetails fetchUserDetails) throws SQLException;

  List<Customer> selectRow(FetchUserDetails fetchUserDetails);
}