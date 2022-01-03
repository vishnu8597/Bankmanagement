package com.bms.controller;

import com.bms.model.SavingsAccount;
import com.bms.services.WithdrawTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * This class manages the operations related to WithdrawTransaction.
 * Filename: WithdrawTransactionController.java
 *
 * @author: Jainesh Ketan Desai
 */

@Controller
public class WithdrawTransactionController {

  @Autowired
  WithdrawTransactionService withdrawTransactionService;

  /*
   * this method does moeny withdrawl transaction on user account and shows
   * message on page if insufficient balance.
   * @param model: passing model object
   * @param amount: passing amount entered by user for withdrawl
   * @param request: gets objects for HttpServletRequest
   * @return: returns WithdrawTransaction pages
   * @throws SQLException
   */
  @PostMapping("/makeTransaction")
  public String makeTransaction(Model model,
                                @RequestParam("amount") String amount,
                                HttpServletRequest request) throws SQLException {

    SavingsAccount savingsAccount =
        withdrawTransactionService.findByName(LoginController.Email).get(0);
    boolean flag = withdrawTransactionService.update(savingsAccount, Integer.parseInt(amount));
    savingsAccount = withdrawTransactionService.findByName(LoginController.Email).get(0);
    model.addAttribute("user", LoginController.Email);
    if (flag) {
      model.addAttribute("balance",
          "Your current balance is " + savingsAccount.getAccountBalance());

    } else {
      model.addAttribute("balance", "Insufficient Balance for " +
          "withdrawal! \n Your current balance is " + savingsAccount.getAccountBalance());
    }
    return "WithdrawTransaction";
  }

  /*
   *This method returns "WithdrawTransaction";
   *
   * @return: returns WithdrawTransaction page
   */
  @GetMapping("/WithdrawTransaction")
  public String getHomepage() {

    return "WithdrawTransaction";
  }

}
