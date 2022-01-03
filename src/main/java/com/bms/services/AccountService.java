package com.bms.services;

import com.bms.dao.AccountDao;

/**
 * This class contains business logic for account setup page after login.
 * Filename: AccountService.java
 *
 * @author: Namit Prakash Dadlani
 */

public class AccountService implements IAccountService {

  public boolean isExistingAccount(String username) {
    AccountDao accountDao = new AccountDao();
    int accountId = accountDao.findAccountIdByEmail(username);
    accountDao.closeAccountConnection();
    return accountId != -1;
  }
}
