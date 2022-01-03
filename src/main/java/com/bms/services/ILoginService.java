package com.bms.services;

import com.bms.model.UserLoginDetails;

/**
 * Purpose of this interface is to create abstract methods for the LoginService class
 * Filename: ILoginService.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

public interface ILoginService {

  boolean verifyEmail(UserLoginDetails userLoginDetails);

  boolean verifyPassword(UserLoginDetails userLoginDetails);
}