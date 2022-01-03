package com.bms.controller;

import com.bms.model.FetchChangeDetails;
import com.bms.model.SavingsAccount;
import com.bms.services.IDepositService;
import com.bms.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Purpose of this class is to function as a controller for the Account changes functionality
 * and renders respective HTML pages
 * Filename: AccountChangesController.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

@Controller
public class AccountChangesController {

  private String Session;
  private final IDepositService depositService;
  private final ITransactionService transactionService;

  @Autowired
  public AccountChangesController(IDepositService depositService, ITransactionService transactionService) {
    this.depositService = depositService;
    this.transactionService = transactionService;
  }

  @GetMapping("/accountchange")
  public String loadAccountChanges() {
    SavingsAccount account = depositService.getLoggedInUserAccount();
    Session = account.getAccountEmail();

    return "AccountChanges";

  }

  @PostMapping("/accountchange/details")
  public void changeDetails(@ModelAttribute FetchChangeDetails fetchChangeDetails, HttpServletResponse httpServletResponse) throws IOException {

    httpServletResponse.sendRedirect("/accountchange/" + fetchChangeDetails.getDetails() + "?email=" + Session);

  }
}