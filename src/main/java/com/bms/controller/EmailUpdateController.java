package com.bms.controller;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.FetchEmailDetails;
import com.bms.services.CheckCredentialsService;
import com.bms.services.ICheckCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for the Email change functionality
 * and renders respective HTML pages
 * Filename: EmailUpdateController.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

@Controller
public class EmailUpdateController {

  private final IAccountUpdateDao accountUpdateDao;
  private final ICheckCredentialsService checkCredentialsService;
  private String email;

  @Autowired
  public EmailUpdateController() {
    this.accountUpdateDao = new AccountUpadateDao();
    this.checkCredentialsService = new CheckCredentialsService();
  }

  @GetMapping("/accountchange/email")
  public String displayEmail(@RequestParam(name = "email", required = true, defaultValue = "blank") String details) {
    this.email = details;
    return "Email";
  }

  @PostMapping("/accountchange/email/home")
  public String updateEmail(@ModelAttribute FetchEmailDetails fetchEmailDetails) throws SQLException, IOException {
    System.out.println(email);
    if (checkCredentialsService.checkNewEmail(fetchEmailDetails.getNewemail())) {
      if (checkCredentialsService.checkPassword(fetchEmailDetails.getPassword(), email)) {
        accountUpdateDao.update(fetchEmailDetails, email);
        accountUpdateDao.updateTranscations(fetchEmailDetails, email);
        accountUpdateDao.updateNominee(fetchEmailDetails, email);
        accountUpdateDao.updateAccountTable(fetchEmailDetails, email);
        return "EmailChangedSuccessfully";
      } else {
        return "WrongPassword";
      }
    } else {
      return "EmailInUse";
    }
  }
}
