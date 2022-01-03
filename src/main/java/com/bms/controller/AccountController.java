package com.bms.controller;

import com.bms.dao.AccountDao;
import com.bms.model.SavingsAccount;
import com.bms.services.AccountCreationService;
import com.bms.services.AccountService;
import com.bms.services.IAccountCreationService;
import com.bms.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class manages the operations related to Account creation and setup after Log In.
 * Filename: AccountController.java
 *
 * @author: Namit Prakash Dadlani
 */

@Controller
public class AccountController {

  private final IAccountCreationService accountCreationService;
  private final IAccountService accountService;

  @Autowired
  public AccountController() {
    this.accountCreationService = new AccountCreationService();
    this.accountService = new AccountService();
  }

  /*
   * This method checks if the user has an existing account and then calls the display logic.
   */
  @GetMapping("/accounts")
  public void initAccountController(Model model, HttpServletResponse httpServletResponse, @RequestParam(name = "email", required = true, defaultValue = "blank") String email) {
    if (!accountService.isExistingAccount(email)) {
      accountCreationService.createAccount(email);
    }
    try {
      httpServletResponse.sendRedirect("/accounts/display?email=" + email);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * This method fetches the account details and passes the data to be displayed on screen after login.
   */
  @GetMapping("/accounts/display")
  public String displayDetails(Model model, @RequestParam(name = "email", required = true, defaultValue = "blank") String email) {
    AccountDao accountDao = new AccountDao();
    SavingsAccount displaySavingsAccount = accountDao.findAccountDetailsByEmail(email);
    accountDao.closeAccountConnection();
    if (displaySavingsAccount.getAccountId() != -1 && null != displaySavingsAccount && !displaySavingsAccount.getAccountEmail().equals("blank")) {
      model.addAttribute("accountUsername", displaySavingsAccount.getAccountEmail());
      model.addAttribute("accountNumber", displaySavingsAccount.getAccountId());
      model.addAttribute("accountBalance", "$" + displaySavingsAccount.getAccountBalance());
    }
    return "AccountDisplay";
  }
}
