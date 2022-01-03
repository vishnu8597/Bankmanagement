package com.bms.dao;

import com.bms.model.Nominee;

import java.sql.SQLException;
import java.util.List;

/**
 * Purpose of this interface is to create abstract methods for the NomineeDAO class
 * Filename: INomineeDAO.java
 *
 * @author: Jainesh Ketan Desai
 */
public interface INomineeDAO {

  /*
   * @param nominee: passes object of Nominee class
   * @return: boolean true or false
   * @throws SQLException
   */
  Boolean insert(Nominee nominee) throws SQLException;

  /*
   *this method return list of users for the given email
   * @param email: passes email parameter in function
   * @return: returns all user for the given email
   */
  List<Nominee> findByEmail(String email);

  /*
   *this method delete row Nominee for the given email
   * @param email: passes email in method for
   * @return: boolean true or false
   * @throws SQLException
   */
  Boolean delete(String email) throws SQLException;
}
