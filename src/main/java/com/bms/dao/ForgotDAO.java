package com.bms.dao;

import com.bms.model.Customer;
import com.bms.services.IForgotService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * ForgotDAO class to manage database for the forgot password
 * Filename: ForgotDAO.java
 *
 * @author: Jainesh Ketan Desai
 */
@Service
public class ForgotDAO
    extends JdbcDaoSupport implements IForgotService, IForgotDAO {

  private final JdbcTemplate jdbcTemplate;

  final DataSource dataSource;

  public ForgotDAO(JdbcTemplate jdbcTemplate, DataSource dataSource) {

    this.jdbcTemplate = jdbcTemplate;
    this.dataSource = dataSource;
  }

  @PostConstruct
  private void initialize() {

    setDataSource(dataSource);
  }

  /*
   * this function gives customer row where email is matched
   * @param name: passes Email in the parameter
   * @return returns all rows where email matches
   */
  @Override
  public List<Customer> findByName(String name) {

    return jdbcTemplate.query("select * from customer where EMAIL=?",
        new Object[]{name}, new CustomerRowMapper());
  }

  /*
   * this methods update password for the given email
   * @param customer: passes customer object in update method
   * @throws SQLException
   */
  @Override
  public Boolean update(Customer customer) throws SQLException {

    String sql1 = "UPDATE customer SET password=? WHERE email=?";
    int status1 = jdbcTemplate.update(sql1, new Object[]{customer.getPassword(),
        customer.getEmail()});
    jdbcTemplate.getDataSource().getConnection().close();

    return status1 != 0;

  }
}

class CustomerRowMapper implements RowMapper<Customer> {

  /*
   *
   * @param resultSet: passes resultset object
   * @return: returns customer object
   * @throws SQLException
   */
  @Override
  public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

    Customer customer = new Customer();
    //id, email, userName, firstName, lastName, address, password
    customer.setEmail(resultSet.getString("email"));
    customer.setPassword(resultSet.getString("password"));
    customer.setUserName(resultSet.getString("userName"));
    customer.setFirstName(resultSet.getString("firstName"));
    customer.setLastName(resultSet.getString("lastName"));

    return customer;
  }

}



