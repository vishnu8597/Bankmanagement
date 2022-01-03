package com.bms.services;

import com.bms.model.UserLoginDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Purpose of this class is to test the LoginService
 * Filename: LoginServiceTest.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

class LoginServiceTest {

  private final UserLoginDetails userLoginDetails = new UserLoginDetails();

  @Test
  void verifyEmailTrue() {
    userLoginDetails.setEmail("testuser@yahoo.com");
    LoginService loginService = new LoginService();
    assertEquals(true, loginService.verifyEmail(userLoginDetails));
  }

  @Test
  void verifyEmailFalse() {
    userLoginDetails.setEmail("testuser@gmail.com");
    LoginService loginService = new LoginService();
    assertEquals(false, loginService.verifyEmail(userLoginDetails));
  }

  @Test
  void verifyPasswordTrue() {
    userLoginDetails.setEmail("testuser@yahoo.com");
    userLoginDetails.setPassword("testpassword");
    LoginService loginService = new LoginService();
    assertEquals(true, loginService.verifyPassword(userLoginDetails));
  }

  @Test
  void verifyPasswordFalse() {
    userLoginDetails.setEmail("testuser@gmail.com");
    userLoginDetails.setPassword("testpassword");
    LoginService loginService = new LoginService();
    assertEquals(false, loginService.verifyPassword(userLoginDetails));
  }
}