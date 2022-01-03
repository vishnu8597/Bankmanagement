package com.bms.controller;

import com.bms.services.ForgotService;
import com.bms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

/**
 * This class manages the operations related to Forgot password.
 * Filename: ForgotPasswordController.java
 *
 * @author: Jainesh Ketan Desai
 */
@Controller
public class ForgotPasswordController {

  @Autowired
  ForgotService forgotService;

  /*
   * this method return forgot password page.
   * @return: returns forgot password  html page
   */
  @GetMapping("/forgotpassword")
  public String loadForgotPassword() {

    return "ForgotPassword";
  }

  /*
   * this method is for changing password for the bank account which takes
   * email and password as parameter
   * @param model: passes model object in method
   * @param email: passes email entered by user
   * @param password: passes password to method entered by user
   * @return: returns  forgotpassword  html page
   * @throws SQLException
   */
  @PostMapping("/forgotpassword")
  public String ChangeForgotPassword(Model model,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password) throws SQLException {

    List<Customer> accounts = forgotService.findByName(email);
    System.out.println(accounts.size());
    int i = accounts.size();
    if (i > 0) {

      Customer customer = accounts.get(0);
      customer.setPassword(password);
      forgotService.update(customer);
      model.addAttribute("resp", "Hi user your password has been updated");

    } else {
      model.addAttribute("email", "this email does not exists");
    }
    return "ForgotPassword";

  }

}
