package com.bms.services;

import com.bms.model.FetchUserDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Purpose of this class is to test the RegistrationService
 * Filename: RegistrationServiceTest.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

class RegistrationServiceTest {

  private final FetchUserDetails fetchUserDetails = new FetchUserDetails();

  @Test
  void verifyEmailTrue() {
    fetchUserDetails.setEmail("testuser@yahoo.com");
    RegistrationService registrationService = new RegistrationService();
    assertEquals(true, registrationService.verifyEmail(fetchUserDetails));
  }

  @Test
  void verifyEmailFalse() {
    fetchUserDetails.setEmail("testuser@gmail.com");
    RegistrationService registrationService = new RegistrationService();
    assertEquals(false, registrationService.verifyEmail(fetchUserDetails));
  }
}