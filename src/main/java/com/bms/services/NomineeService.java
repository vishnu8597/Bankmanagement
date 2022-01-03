package com.bms.services;

import com.bms.dao.NomineeDAO;
import com.bms.model.Nominee;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Purpose of this class is to add nominee  and delete nominee into the user
 * account
 * Filename: NomineeService.java
 *
 * @author: Jainesh ketan Desai
 */

@Service
public class NomineeService implements INomineeService {

  NomineeDAO nomineeDAO;

  public Boolean insert(Nominee nominee) throws SQLException {

    return nomineeDAO.insert(nominee);

  }

  /*
   *this method return list of users for the given email
   * @param email: passes email parameter in function
   * @return: returns all user for the given email
   */
  public List<Nominee> findByEmail(String email) {

    return nomineeDAO.findByEmail(email);
  }

  /*
   *this method delete row Nominee for the given email
   * @param email: passes email in method for
   * @return: boolean true or false
   * @throws SQLException
   */
  public Boolean delete(String email) throws SQLException {

    return nomineeDAO.delete(email);

  }

}

