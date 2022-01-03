package com.bms.services;

import com.bms.model.FetchUserDetails;

/**
 * Purpose of this interface is to create abstract methods for the RegistrationService class
 * Filename: IRegistrationService.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public interface IRegistrationService {

  boolean verifyEmail(FetchUserDetails fetchUserDetails);
}