package com.bms.controller;

import com.bms.model.AccountTransactionRequest;
import com.bms.model.SavingsAccount;
import com.bms.model.Transaction;
import com.bms.services.IDepositService;
import com.bms.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Purpose of this class is to manage the 'deposit' features
 * and renders respective HTML pages
 * Filename: DepositController.java
 *
 * @author: Anjali Chaudhary
 */
@Controller
@RequestMapping("/accounts")
public class DepositController {

  private final IDepositService depositService;
  private final ITransactionService transactionService;

  @Autowired
  public DepositController(IDepositService depositService, ITransactionService transactionService) {
    this.depositService = depositService;
    this.transactionService = transactionService;
  }

  /**
   * Get account page
   *
   * @return Account home page with account data
   */
  @GetMapping("/home")
  public String getAccountPage(Model model) {
    SavingsAccount account = depositService.getLoggedInUserAccount();
    List<Transaction> transactions = transactionService.getRecentTransaction();
    model.addAttribute("account", account);
    model.addAttribute("transactions", transactions);
    return "Account";
  }

  /**
   * Get deposit page
   *
   * @return deposit page
   */
  @GetMapping("/deposit")
  public String getDepositPage(Model model) {
    SavingsAccount account = depositService.getLoggedInUserAccount();
    model.addAttribute("account", account);
    return "Deposit";
  }

  /**
   * Account deposit transaction
   * <p>
   * After the deposit transaction, redirect to account home page
   *
   * @throws Exception
   */
  @PostMapping("/deposit")
  public void deposit(Model model, AccountTransactionRequest request, HttpServletResponse httpServletResponse)
          throws Exception {
    SavingsAccount account = depositService.deposit(request.getAmount());
    model.addAttribute("account", account);
    httpServletResponse.sendRedirect("/accounts/home");
  }

  @PostMapping("/Search")
  public void search(HttpServletResponse httpServletResponse) throws IOException {
    httpServletResponse.sendRedirect("/Search");
  }

}
