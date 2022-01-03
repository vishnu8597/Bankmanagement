package com.bms.services;

import com.bms.dao.AccountUpadateDao;
import com.bms.model.FetchFirstName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckFirstNameServiceTest {

  private final AccountUpadateDao accountUpadateDao = new AccountUpadateDao();
  private final FetchFirstName fetchFirstName = new FetchFirstName();
  private final CheckFirstNameService checkFirstNameService = new CheckFirstNameService();
  private final String email = "testuser@yahoo.com";

  @Test
  void checkFirstNameTrue() throws SQLException {
    fetchFirstName.setFirstname("vishnu");
    assertEquals(true, checkFirstNameService.CheckFirstName(fetchFirstName.getFirstname(), email));
  }

  @Test
  void checkFirstNameFalse() throws SQLException {
    fetchFirstName.setFirstname("ronnie");
    assertEquals(false, checkFirstNameService.CheckFirstName(fetchFirstName.getFirstname(), email));
  }
}