package com.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller class handles the routing for Customer Support.
 * Filename: TransactionHistoryController.java
 *
 * @author: Namit Prakash Dadlani
 */

@Controller
public class CustomerSupportController {

  @GetMapping("/CustomerSupport")
  public String displayCustomerSupport() {
    return "CustomerSupport";
  }

}
