package com.bms.controller;

import com.bms.model.UserLoginDetails;
import com.bms.services.ILoginService;
import com.bms.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for the login functionality
 * Filename: LoginController.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

@Controller
public class LoginController {

  public static String Email = "";
  private final ILoginService loginService;

  @Autowired
  public LoginController() {
    this.loginService = new LoginService();
  }

  @GetMapping("/Login")
  public String loadLogin() {
    return "Login";
  }

  @GetMapping("/RegisterUser/LoginUser")
  public String logingUser() {
    return "Login";
  }

  @PostMapping("/accounts")
  public String loginUser(@ModelAttribute UserLoginDetails userLoginDetails, HttpServletResponse httpServletResponse, HttpSession session) throws SQLException {
    if (!loginService.verifyEmail(userLoginDetails)) {
      return "emailNotRegistered";
    }
    if (!loginService.verifyPassword(userLoginDetails)) {
      return "WrongPassword";
    }
    try {
      Email = userLoginDetails.getEmail();
      session.setAttribute("username", userLoginDetails.getEmail());
      httpServletResponse.sendRedirect("/accounts?email=" + userLoginDetails.getEmail());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "AccountDisplay";
  }
}