package com.bms.controller;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.FetchAddressDetails;
import com.bms.services.CheckAddressService;
import com.bms.services.CheckCredentialsService;
import com.bms.services.ICheckAddressService;
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
 * Purpose of this class is to function as a controller for the Address change functionality
 * and renders respective HTML pages
 * Filename: AddressChangesController.java
 *
 * @author: Dampetla Vishnu Sumanth
 */

@Controller
public class AddressChangeController {

  private final IAccountUpdateDao accountUpdateDao;
  private final ICheckCredentialsService checkCredentialsService;
  private final ICheckAddressService checkAddressService;
  private String Session;


  @Autowired
  public AddressChangeController() {
    this.accountUpdateDao = new AccountUpadateDao();
    this.checkCredentialsService = new CheckCredentialsService();
    this.checkAddressService = new CheckAddressService();
  }

  @GetMapping("/accountchange/address")
  public String displayFirstName(@RequestParam(name = "email", required = true, defaultValue = "blank") String email) {
    Session = email;
    return "Address";
  }

  @PostMapping("/accountchange/address/home")
  public String updateFirstName(@ModelAttribute FetchAddressDetails fetchAddressDetails) throws SQLException, IOException {

    if (checkCredentialsService.checkPassword(fetchAddressDetails.getPassword(), Session)) {
      if (!checkAddressService.CheckAddress(fetchAddressDetails.getAddress(), Session)) {
        accountUpdateDao.updateAddress(fetchAddressDetails, Session);
        return "AddressUpdated";
      } else {
        return "AddressInUse";
      }
    } else {
      return "WrongPassword";
    }
  }
}