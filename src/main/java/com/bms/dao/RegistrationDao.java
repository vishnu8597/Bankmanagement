package com.bms.dao;

import com.bms.model.Customer;
import com.bms.model.FetchUserDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Purpose of this class is access data from the database to enable registration functionality
 * Filename: RegistrationDao.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public class RegistrationDao implements IRegistrationDao {

  final String DB_URL = "jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_3_DEVINT";
  final String DB_USER = "CSCI5308_3_DEVINT_USER";
  final String DB_PWD = "9nEWerA7YdR";
  private final JdbcTemplate jdbcTemplate;

  public RegistrationDao() {
    this.jdbcTemplate = new JdbcTemplate(getDataSource());
  }


  public DataSource getDataSource() {
    DataSource dataSource = new DriverManagerDataSource(DB_URL, DB_USER, DB_PWD);
    return dataSource;
  }

  /*
   * Purpose of this method is to execute a insert query which fetches the details from the user
   * and registers a new user.
   */
  public void insertDetails(FetchUserDetails fetchUserDetails) throws SQLException {
    jdbcTemplate.update("INSERT INTO customer values (" + 1 + "," + '"' + fetchUserDetails.getEmail() + '"' + "," + '"' + fetchUserDetails.getUsername() + '"' + "," + '"' + fetchUserDetails.getFirstName() + '"' + ","
            + '"' + fetchUserDetails.getLastName() + '"' + "," + '"' + fetchUserDetails.getAddress() + '"' + "," + '"' + fetchUserDetails.getPassword() + '"' + ")"
    );
  }

  /*
   * Purpose of this method is to check the E-mail's existence in the database to avoid creating a duplicate
   * user for an existing E-mail
   */
  public List<Customer> selectRow(FetchUserDetails fetchUserDetails) {
    List<Customer> resultSet =
            jdbcTemplate.query(
                    "select * from customer where email= " + '"' + fetchUserDetails.getEmail() + '"',
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