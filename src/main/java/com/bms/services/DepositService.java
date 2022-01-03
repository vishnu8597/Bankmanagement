package com.bms.services;

import com.bms.dao.IDepositDAO;
import com.bms.model.Mode;
import com.bms.model.SavingsAccount;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * The purpose of this service class is to manage deposit transactions
 * Filename : DepositService.java
 *
 * @author: Anjali Chaudhary
 */
@Service
public class DepositService implements IDepositService {

  private final IDepositDAO depositDAO;
  private final HttpSession httpSession;
  private final ITransactionService transactionService;

  @Autowired
  public DepositService(IDepositDAO depositDAO, HttpSession httpSession, ITransactionService transactionService) {
    this.depositDAO = depositDAO;
    this.httpSession = httpSession;
    this.transactionService = transactionService;
  }

  /**
   * Get account using email id
   *
   * @return account
   */
  @Override
  public SavingsAccount getAccountByEmail(String email) {
    return depositDAO.findAccountDetailsByEmail(email);
  }

  /**
   * Get loggedIn user account
   */
  @Override
  public SavingsAccount getLoggedInUserAccount() {
    return getAccountByEmail(httpSession.getAttribute("username").toString());
  }

  /**
   * Account deposit transaction
   * Make entry in the transaction table after deposit
   *
   * @return account data after deposit
   */
  @Override
  public SavingsAccount deposit(BigDecimal amount) throws Exception {
    SavingsAccount account = getLoggedInUserAccount();

    if (null == account) {
      throw new Exception("Account not found");
    }

    BigDecimal existingAmount = new BigDecimal(account.getAccountBalance());

    account.setAccountBalance(existingAmount.add(amount).floatValue());

    account = depositDAO.updateAccount(account);

    transactionService.createTransaction(new DateTime(), "Account Deposit",
            "Account/deposit/" + TransactionService.generateRandom(), amount.floatValue(), Mode.CREDIT.getValue(),
            account.getAccountBalance(), account.getAccountEmail(), null, account.getAccountEmail());

    return account;
  }

}
