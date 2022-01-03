package com.bms.services;

import com.bms.dao.AccountUpadateDao;
import com.bms.model.FetchLastName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckLastNameServiceTest {

  private final AccountUpadateDao accountUpadateDao = new AccountUpadateDao();
  private final FetchLastName fetchLastName = new FetchLastName();
  private final CheckLastNameService checkLastNameService = new CheckLastNameService();
  private final String email = "testuser@yahoo.com";

  @Test
  void checkLastNameTrue() throws SQLException {
    fetchLastName.setLastname("yadav");
    assertEquals(true, checkLastNameService.CheckLastName(fetchLastName.getLastname(), email));
  }

  @Test
  void checkLastNameFlase() throws SQLException {
    fetchLastName.setLastname("sumanth");
    assertEquals(false, checkLastNameService.CheckLastName(fetchLastName.getLastname(), email));
  }

}