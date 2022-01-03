package com.bms.controller;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.FetchFirstName;
import com.bms.services.CheckCredentialsService;
import com.bms.services.CheckFirstNameService;
import com.bms.services.ICheckCredentialsService;
import com.bms.services.ICheckFirstNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for the First Name change functionality
 * and renders respective HTML pages
 * Filename: FirstNameChangeController.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

@Controller
public class FirstNameChangeController {

  private final IAccountUpdateDao accountUpdateDao;
  private final ICheckCredentialsService checkCredentialsService;
  private final ICheckFirstNameService checkFirstNameService;
  private String email;

  @Autowired
  public FirstNameChangeController() {
    this.accountUpdateDao = new AccountUpadateDao();
    this.checkCredentialsService = new CheckCredentialsService();
    this.checkFirstNameService = new CheckFirstNameService();
  }

  @GetMapping("/accountchange/firstname")
  public String displayFirstName(@RequestParam(name = "email", required = true, defaultValue = "blank") String details) {
    this.email = details;
    return "firstname";
  }

  @PostMapping("/accountchange/firstname/home")
  public String updateFirstName(@ModelAttribute FetchFirstName fetchFirstName) throws SQLException, IOException {
    if (checkCredentialsService.checkPassword(fetchFirstName.getPassword(), email)) {
      if (!checkFirstNameService.CheckFirstName(fetchFirstName.getFirstname(), email)) {
        accountUpdateDao.updateFirstName(fetchFirstName, email);
        return "firstNameUpdated";
      } else {
        return "FirstNameInUse";
      }
    } else {
      return "WrongPassword";
    }
  }
}