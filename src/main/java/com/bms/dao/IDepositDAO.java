package com.bms.dao;

import com.bms.model.SavingsAccount;

/**
 * Purpose of this interface is to implement the abstract methods for the DepositDAO class
 * Filename: IDepositDAO.java
 *
 * @author: Anjali Chaudhary
 */

public interface IDepositDAO {

  SavingsAccount updateAccount(SavingsAccount account);

  SavingsAccount findAccountDetailsByEmail(String email);

}
