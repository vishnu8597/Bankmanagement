package com.bms.dao;

import com.bms.model.Account;

/**
 * Purpose of this interface is to create abstract methods for the AccountDao class
 * Filename: AccountController.java
 *
 * @author: Namit Prakash Dadlani
 */

public interface IAccountDao {

  int findAccountIdByEmail(String username);

  Account findAccountDetailsByEmail(String username);

  int findHighestAccountNum();

}
