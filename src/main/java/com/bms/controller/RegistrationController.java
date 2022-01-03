package com.bms.controller;

import com.bms.dao.RegistrationDao;
import com.bms.model.FetchUserDetails;
import com.bms.services.IRegistrationService;
import com.bms.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for the registration functionality
 * Filename: RegistrationController.java
 *
 * @author: Jagadeeswara Aditya Busam
 */

@Controller
public class RegistrationController {

  private final IRegistrationService registrationService;

  @Autowired
  public RegistrationController() {
    this.registrationService = new RegistrationService();
  }

  @GetMapping("/Registration")
  public String loadRegistration() {
    return "Registration";
  }

  @PostMapping("/Login")
  public String registerUser(@ModelAttribute FetchUserDetails fud, HttpServletResponse httpServletResponse, RegistrationDao registrationDao) throws SQLException, IOException {
    if (registrationService.verifyEmail(fud)) {
      return "EmailExists";
    } else {
      registrationDao.insertDetails(fud);
      httpServletResponse.sendRedirect("/RegisterUser/LoginUser");
    }
    return "Login";
  }
}