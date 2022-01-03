package com.bms.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is the test class for AccountService logic.
 * Filename: AccountServiceTest.java
 *
 * @author: Namit Prakash Dadlani
 */

class AccountServiceTest {

  @Test
  void isExistingAccount_true() {
    AccountService accountService = new AccountService();
    assertTrue(accountService.isExistingAccount("namit123"), "isExistingAccount() is not able to fetch existing account by username.");
  }

  @Test
  void isExistingAccount_false() {
    AccountService accountService = new AccountService();
    assertFalse(accountService.isExistingAccount("ironman"), "isExistingAccount() is not able to fetch existing account by username.");
  }
}