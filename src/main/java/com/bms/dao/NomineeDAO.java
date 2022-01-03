package com.bms.dao;
import com.bms.model.Nominee;
import com.bms.services.INomineeService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * This class manages the database operations related to Nominee.
 * Filename: NomineeDAO.java
 *
 * @author: Jainesh Ketan Desai
 */


@Service
public class NomineeDAO implements INomineeService, INomineeDAO {

  private final JdbcTemplate jdbcTemplate;

  final DataSource dataSource;

  public NomineeDAO(JdbcTemplate jdbcTemplate, DataSource dataSource) {

    this.jdbcTemplate = jdbcTemplate;
    this.dataSource = dataSource;
  }

  @PostConstruct
  private void initialize() {

    jdbcTemplate.setDataSource(this.dataSource);
  }

  /*
   * @param nominee: passes object of Nominee class
   * @return: boolean true or false
   * @throws SQLException
   */
  @Override
  public Boolean insert(Nominee nominee) throws SQLException {

    String sql = "INSERT INTO Nominee (Name, Relantionship, email) VALUES (?,?,?)";
    int status = jdbcTemplate.update(sql,
        new Object[]{
            nominee.getName(),
            nominee.getRelantionship(),
            nominee.getEmail()
        });
    return status != 0;

  }

  /*
   *this method return list of users for the given email
   * @param email: passes email parameter in function
   * @return: returns all user for the given email
   */
  @Override
  public List<Nominee> findByEmail(String email) {

    return jdbcTemplate.query("select * from Nominee where EMAIL=?",
        new Object[]{email}, new NomineeRowMapper());
  }

  /*
   *this method delete row Nominee for the given email
   * @param email: passes email in method for
   * @return: boolean true or false
   * @throws SQLException
   */
  @Override
  public Boolean delete(String email) throws SQLException {

    String sql = "delete from Nominee where email=?";
    int status = jdbcTemplate.update(sql,
        new Object[]{
            email
        });
    return status != 0;

  }

}

