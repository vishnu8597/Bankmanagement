package com.bms.services;

import com.bms.dao.AccountUpadateDao;
import com.bms.dao.IAccountUpdateDao;
import com.bms.model.FetchAddressDetails;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckAddressServiceTest {

  private final CheckAddressService checkAddressService = new CheckAddressService();
  private final IAccountUpdateDao accountUpadateDao = new AccountUpadateDao();
  private final FetchAddressDetails fetchAddressDetails = new FetchAddressDetails();
  private final String email = "testuser@yahoo.com";

  @Test
  void checkAddressTrue() throws SQLException {
    fetchAddressDetails.setAddress("park vic apartments");
    assertEquals(true, checkAddressService.CheckAddress(fetchAddressDetails.getAddress(), email));
  }

  @Test
  void checkAddressFalse() throws SQLException {
    fetchAddressDetails.setAddress("halifax");
    assertEquals(false, checkAddressService.CheckAddress(fetchAddressDetails.getAddress(), email));
  }
}