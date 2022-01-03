package com.bms.services;

import com.bms.dao.AccountUpadateDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckCredentialsServiceTest {

  AccountUpadateDao accountUpadateDao = new AccountUpadateDao();
  private final CheckCredentialsService checkCredentialsService = new CheckCredentialsService();

  @Test
  void checkNewEmailTrue() throws SQLException {
    String email = "testuser@gmail.com";
    assertEquals(true, checkCredentialsService.checkNewEmail(email));
  }

  @Test
  void checkNewEmailFalse() throws SQLException {
    String email = "testuser@yahoo.com";
    assertEquals(false, checkCredentialsService.checkNewEmail(email));
  }

  @Test
  void checkPasswordTrue() throws SQLException {
    String password = "testpassword";
    String mail = "testuser@yahoo.com";
    assertEquals(true, checkCredentialsService.checkPassword(password, mail));

  }

  @Test
  void checkPasswordFalse() throws SQLException {
    String password = "wrongpassword";
    String mail = "testuser@yahoo.com";
    assertEquals(false, checkCredentialsService.checkPassword(password, mail));


  }

}