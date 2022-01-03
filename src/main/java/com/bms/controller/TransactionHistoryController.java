package com.bms.controller;

import com.bms.model.TransactionDisplay;
import com.bms.services.ITransactionHistoryService;
import com.bms.services.TransactionHistoryService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This class manages the operations related to Transaction History of customer.
 * Filename: TransactionHistoryController.java
 *
 * @author: Namit Prakash Dadlani
 */

@Controller
public class TransactionHistoryController {

  private final ITransactionHistoryService transactionHistoryService;
  String greetingMessage;
  List<TransactionDisplay> displayTransactions;

  @Autowired
  public TransactionHistoryController() {
    this.transactionHistoryService = new TransactionHistoryService();
  }

  /*
   * This method initializes the dynamic display messages after fetching database and session data.
   */
  @GetMapping("/TransactionHistory")
  public String initTransactionHistory(Model model, HttpSession httpSession) {
    greetingMessage = "Hello ";
    try {
      String fetchedName = transactionHistoryService.fetchNameForTransactionHistory(httpSession.getAttribute("username").toString());
      greetingMessage += fetchedName;
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
    greetingMessage += "!";
    model.addAttribute("greetingMessage", greetingMessage);
    model.addAttribute("displayTransactions", displayTransactions);
    model.addAttribute("descriptionMessage", "");
    return "TransactionHistoryHome";
  }

  /*
   * This method calls the logic for showing all the transactions.
   */
  @GetMapping("/TransactionHistory/showAll")
  public String showAllTransactions(Model model, HttpSession httpSession) {
    try {
      String bodyMessage = "";
      String highestValues = "";
      String username = httpSession.getAttribute("username").toString();
      displayTransactions = transactionHistoryService.showAllTransactionHistory(username);
      if (displayTransactions.size() == 0) {
        bodyMessage = "Sorry, there are no transactions to display.";
      } else {
        highestValues = transactionHistoryService.findHighestTransactions(displayTransactions);
      }
      model.addAttribute("greetingMessage", greetingMessage);
      model.addAttribute("displayTransactions", displayTransactions);
      model.addAttribute("bodyMessage", bodyMessage);
      model.addAttribute("highestValues", highestValues);
    } catch (NullPointerException e) {
      e.printStackTrace();
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    return "TransactionHistoryHome";
  }

  /*
   * This method calls the logic for showing the transactions within a date range.
   */
  @GetMapping("/TransactionHistory/showWithinRange")
  public String showWithinRangeTransactions(Model model, HttpSession httpSession,
                                            @RequestParam(name = "begin-date", required = true) String beginDate,
                                            @RequestParam(name = "end-date", required = true) String endDate) {
    try {
      String bodyMessage = "";
      String highestValues = "";
      String username = httpSession.getAttribute("username").toString();
      displayTransactions = transactionHistoryService.showWithinRangeTransactionHistory(username,
              new DateTime(beginDate),
              new DateTime(endDate));
      if (displayTransactions.size() == 0) {
        bodyMessage = "Sorry, there are no transactions to display.";
      } else {
        highestValues = transactionHistoryService.findHighestTransactions(displayTransactions);
      }
      model.addAttribute("greetingMessage", greetingMessage);
      model.addAttribute("displayTransactions", displayTransactions);
      String descriptionMessage = "Showing transactions between " + beginDate + " and " + endDate + ".";
      model.addAttribute("descriptionMessage", descriptionMessage);
      model.addAttribute("bodyMessage", bodyMessage);
      model.addAttribute("highestValues", highestValues);
    } catch (NullPointerException e) {
      e.printStackTrace();
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    return "TransactionHistoryHome";
  }


}
