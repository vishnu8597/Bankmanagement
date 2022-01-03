package com.bms.dao;

import com.bms.model.Customer;
import com.bms.model.UserLoginDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

/**
 * Purpose of this class is to access data from the database to enable login functionality
 * Filename: LoginDao.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public class LoginDao implements ILoginDao {

  final String DB_URL = "jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_3_DEVINT";
  final String DB_USER = "CSCI5308_3_DEVINT_USER";
  final String DB_PWD = "9nEWerA7YdR";
  private final JdbcTemplate jdbcTemplate;

  public LoginDao() {
    this.jdbcTemplate = new JdbcTemplate(getDataSource());
  }


  public DataSource getDataSource() {
    DataSource dataSource = new DriverManagerDataSource(DB_URL, DB_USER, DB_PWD);
    return dataSource;
  }

  /*
   * Purpose of this method is to check the user details at the time of login by checking
   * the details in the database
   */
  public List<Customer> verifyDetails(UserLoginDetails userLoginDetails) {
    List<Customer> resultSet =
            jdbcTemplate.query(
                    "select * from customer where email= " + '"' + userLoginDetails.getEmail() + '"',
                    (rs, rowNum) ->
                            new Customer(
                                    rs.getString("email"),
                                    rs.getString("userName"),
                                    rs.getString("firstName"),
                                    rs.getString("lastName"),
                                    rs.getString("address"),
                                    rs.getString("password")
                            )
            );
    return resultSet;
  }
}