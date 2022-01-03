package com.bms.controller;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.FetchDeleteAccountDetails;
import com.bms.model.SavingsAccount;
import com.bms.services.CheckCredentialsService;
import com.bms.services.ICheckCredentialsService;
import com.bms.services.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for deativating account functionality
 * and renders respective HTML pages
 * Filename: DeactivateAccountController.java
 *
 * @author: Dampetla Vishnu Sumanth
 */
@Controller
public class DeactivateAccountController {

  private final IAccountUpdateDao accountUpdateDao;
  private final ICheckCredentialsService checkCredentialsService;
  private final IDepositService depositService;
  private String Session;

  @Autowired
  public DeactivateAccountController(IDepositService depositService) {
    this.depositService = depositService;
    this.accountUpdateDao = new AccountUpadateDao();
    this.checkCredentialsService = new CheckCredentialsService();
  }

  @GetMapping("/deactiavte")
  public String deleteAccount() {

    return "delete";
  }

  @PostMapping("/delete/account")
  public String deletedAccount(@ModelAttribute FetchDeleteAccountDetails fetchDeleteAccountDetails) throws SQLException {
    SavingsAccount account = depositService.getLoggedInUserAccount();
    Session = account.getAccountEmail();
    if (checkCredentialsService.checkPassword(fetchDeleteAccountDetails.getPassword(), Session)) {
      accountUpdateDao.delete(Session);
      return "AccountDeletedSuccessfully";

    } else {
      return "WrongPassword";
    }
  }
}
