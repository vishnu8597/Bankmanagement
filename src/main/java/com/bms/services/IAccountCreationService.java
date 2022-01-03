package com.bms.services;

/**
 * Purpose of this interface is to create abstract methods for Account creation logic.
 * Filename: IAccountCreationService.java
 *
 * @author: Namit Prakash Dadlani
 */

public interface IAccountCreationService {

  void createAccount(String email);

  int generateNextAccountId();

}
