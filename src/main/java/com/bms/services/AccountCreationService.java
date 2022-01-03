package com.bms.services;

import com.bms.dao.AccountDao;
import com.bms.model.SavingsAccount;

import java.sql.Date;

/**
 * This class contains business logic to create an account after generating a new account id.
 * Filename: AccountCreationService.java
 *
 * @author: Namit Prakash Dadlani
 */

public class AccountCreationService implements IAccountCreationService {

  public void createAccount(String email) {
    AccountDao accountDao = new AccountDao();
    SavingsAccount newSavingsSavingsAccount = new SavingsAccount(generateNextAccountId(), "Savings", new Date(System.currentTimeMillis()),
            email, 0.0f, "", null);
    boolean result = accountDao.insertNewAccount(newSavingsSavingsAccount);
    accountDao.closeAccountConnection();
  }

  public int generateNextAccountId() {
    int currentMaxAccountNum = -1;
    AccountDao accountDao = new AccountDao();
    currentMaxAccountNum = accountDao.findHighestAccountNum();
    accountDao.closeAccountConnection();
    if (currentMaxAccountNum != -1) {
      currentMaxAccountNum += 5;
    }
    return currentMaxAccountNum;
  }
}