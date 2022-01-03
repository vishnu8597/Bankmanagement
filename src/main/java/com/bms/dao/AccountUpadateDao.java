package com.bms.dao;

import com.bms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * Purpose of this class is to function as a controller for the Address change functionality
 * Filename: AccountUpdateDao.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

@Service
public class AccountUpadateDao implements IAccountUpdateDao {

  private final String url = "jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_3_DEVINT";
  private final String username = "CSCI5308_3_DEVINT_USER";
  private final String password = "9nEWerA7YdR";

  @Autowired
  private final JdbcTemplate jdbcTemplate = new JdbcTemplate(setDataSource());

  public DataSource setDataSource() {
    DataSource dataSource = new DriverManagerDataSource(url, username, password);
    return dataSource;
  }

  /**
   * Updates email address in customer table
   * Parameters:
   * fetchEmailDetails - Object that has data from frontend
   * email - email that needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int update(FetchEmailDetails fetchEmailDetails, String email) {
    jdbcTemplate.update("update transactions set email = ? where email = ?", fetchEmailDetails.getNewemail(), email);
    jdbcTemplate.update("update Nominee set email = ? where email = ?", fetchEmailDetails.getNewemail(), email);
    return jdbcTemplate.update(
            "update customer set email = ? where email = ?",
            fetchEmailDetails.getNewemail(), email);
  }

  /**
   * Updates email address in ACCOUNTS table
   * Parameters:
   * fetchEmailDetails - Object that has data from frontend
   * email - email that needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int updateAccountTable(FetchEmailDetails fetchEmailDetails, String email) {
    return jdbcTemplate.update(
            "update ACCOUNTS set EMAIL = ? where EMAIL = ?",
            fetchEmailDetails.getNewemail(), email);
  }

  /**
   * Updates email address in transactions table
   * Parameters:
   * fetchEmailDetails - Object that has data from frontend
   * email - email that needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int updateTranscations(FetchEmailDetails fetchEmailDetails, String email) {
    return jdbcTemplate.update(
            "update transactions set EMAIL = ? where EMAIL = ?",
            fetchEmailDetails.getNewemail(), email);
  }

  /**
   * Updates email address in Nominee table
   * Parameters:
   * fetchEmailDetails - Object that has data from frontend
   * email - email that needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int updateNominee(FetchEmailDetails fetchEmailDetails, String email) {
    return jdbcTemplate.update(
            "update Nominee set EMAIL = ? where EMAIL = ?",
            fetchEmailDetails.getNewemail(), email);
  }

  /**
   * Updates first name  in customer table
   * Parameters:
   * fetchFirstName - Object that has data from frontend
   * email - email where the first name needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int updateFirstName(FetchFirstName fetchFirstName, String email) {
    return jdbcTemplate.update(
            "update customer set firstName = ? where email = ?",
            fetchFirstName.getFirstname(), email);
  }

  /**
   * Updates last name in customer table
   * Parameters:
   * fetchLastName - Object that has data from frontend
   * email - email where the last name needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int updateLastName(FetchLastName fetchLastName, String email) {
    return jdbcTemplate.update(
            "update customer set lastName = ? where email = ?",
            fetchLastName.getLastname(), email);
  }

  /**
   * Updates address in customer table
   * Parameters:
   * fetchAddresssDetails - Object that has data from frontend
   * email - email where the address needs to be updated
   * Returns:
   * number for rows that are affected by the query
   */
  public int updateAddress(FetchAddressDetails fetchAddressDetails, String email) {
    return jdbcTemplate.update(
            "update customer set address = ? where email = ?",
            fetchAddressDetails.getAddress(), email);
  }

  /**
   * deletes rows of corresponding email address in ACCOUNTS,transcations,customer,nominee table
   * Parameters:
   * email - email where the rows need to be deleted
   */
  public void delete(String email) {
    jdbcTemplate.update("DELETE FROM ACCOUNTS WHERE email=?", email);
    jdbcTemplate.update("DELETE FROM transactions WHERE email=?", email);
    jdbcTemplate.update("DELETE FROM customer WHERE email=?", email);
    jdbcTemplate.update("DELETE FROM Nominee WHERE email=?", email);
  }

  /**
   * Selects the row of the given email
   * Parameters:
   * email - email that fetches the row
   * Returns:
   * A list with all the rows that affected by the select auery
   */
  public List<Customer> select(String email) {
    return jdbcTemplate.query(
            "select * from customer where email= " + '"' + email + '"',
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
  }
}
