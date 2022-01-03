package com.bms.dao;

import com.bms.model.Customer;
import com.bms.model.UserLoginDetails;

import javax.sql.DataSource;
import java.util.List;

/**
 * Purpose of this interface is to create abstract methods for the LoginDao class
 * Filename: ILoginDao.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public interface ILoginDao {

  DataSource getDataSource();

  List<Customer> verifyDetails(UserLoginDetails userLoginDetails);
}