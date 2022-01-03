package com.bms.dao;

import com.bms.model.Nominee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class manages the database operations related to Nominee.
 * Filename: NomineeDAO.java
 *
 * @author: Jainesh Ketan Desai
 */

public class NomineeRowMapper implements RowMapper<Nominee> {

  /*
   *
   * @param resultSet: passes Result set Object
   * @return: nommine object
   * @throws SQLException
   */
  @Override
  public Nominee mapRow(ResultSet resultSet, int i) throws SQLException {

    Nominee nominee = new Nominee();

    nominee.setEmail(resultSet.getString("email"));
    return nominee;
  }

}
