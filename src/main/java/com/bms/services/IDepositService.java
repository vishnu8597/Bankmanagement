package com.bms.services;

import com.bms.model.SavingsAccount;

import java.math.BigDecimal;

/**
 * Purpose of this interface is to implement abstract methods for IDepositService class
 * Filename: IDepositService.java
 *
 * @author: Anjali Chaudhary
 */
public interface IDepositService {

  SavingsAccount getAccountByEmail(String email);

  SavingsAccount getLoggedInUserAccount();

  SavingsAccount deposit(BigDecimal amount) throws Exception;

}
