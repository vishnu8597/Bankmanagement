package com.bms.services;

import com.bms.dao.AccountDao;
import com.bms.model.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test class for AccountCreationService logic.
 * Filename: AccountCreationServiceTest.java
 *
 * @author: Namit Prakash Dadlani
 */
class AccountCreationServiceTest {

  @Test
  void createAccount() {
    AccountCreationService accountCreationService = new AccountCreationService();
    accountCreationService.createAccount("test");
    AccountDao accountDao = new AccountDao();
    SavingsAccount displaySavingsAccount = accountDao.findAccountDetailsByEmail("test");
    assertEquals("test", displaySavingsAccount.getAccountEmail());
  }

  @Test
  void generateNextAccountId() {
    int currentMaxAccountNum = -1;
    AccountCreationService accountCreationService = new AccountCreationService();
    AccountDao accountDao = new AccountDao();
    currentMaxAccountNum = accountDao.findHighestAccountNum();
    assertEquals(currentMaxAccountNum + 5, accountCreationService.generateNextAccountId());
  }

}