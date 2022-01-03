package com.bms.controller;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.FetchLastName;
import com.bms.services.CheckCredentialsService;
import com.bms.services.CheckLastNameService;
import com.bms.services.ICheckCredentialsService;
import com.bms.services.ICheckLastNameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for the Last Name change functionality
 * and renders respective HTML pages
 * Filename: LastNameChangeController.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

@Controller
public class LastNameChangeController {

  private final IAccountUpdateDao accountUpdateDao;
  private final ICheckCredentialsService checkCredentialsService;
  private final ICheckLastNameService checkLastNameService;
  private String Session;

  public LastNameChangeController() {
    this.accountUpdateDao = new AccountUpadateDao();
    this.checkCredentialsService = new CheckCredentialsService();
    this.checkLastNameService = new CheckLastNameService();
  }

  @GetMapping("/accountchange/lastname")
  public String displayLastName(@RequestParam(name = "email", required = true, defaultValue = "blank") String email) {
    this.Session = email;
    return "lastname";
  }

  @PostMapping("/accountchange/lastname/home")
  public String updateLastName(@ModelAttribute FetchLastName fetchLastName) throws SQLException, IOException {

    if (checkCredentialsService.checkPassword(fetchLastName.getPassword(), Session)) {
      if (!checkLastNameService.CheckLastName(fetchLastName.getLastname(), Session)) {
        accountUpdateDao.updateLastName(fetchLastName, Session);
        return "lastNameUpdated";
      } else {
        return "LastNameInUse";
      }
    } else {
      return "WrongPassword";
    }
  }
}
