package com.bms.controller;

import com.bms.model.AccountTransactionRequest;
import com.bms.model.SavingsAccount;
import com.bms.model.Transaction;
import com.bms.services.IDepositService;
import com.bms.services.ITransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test cases for the DepositController class
 * Filename : DepositControllerTest.java
 *
 * @author Anjali Chaudhary
 */

public class DepositControllerTest {

  private IDepositService depositService;
  private ITransactionService transactionService;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    depositService = Mockito.mock(IDepositService.class);
    transactionService = Mockito.mock(ITransactionService.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new DepositController(depositService, transactionService)).build();
  }

  @Test
  public void getAccountPage_returnSuccess() throws Exception {
    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");

    Transaction t1 = new Transaction();
    Transaction t2 = new Transaction();

    List<Transaction> transactions = Lists.newArrayList(t1, t2);

    Mockito.when(depositService.getLoggedInUserAccount()).thenReturn(account);
    Mockito.when(transactionService.getRecentTransaction()).thenReturn(transactions);

    mockMvc.perform(get("/accounts/home"))
            .andExpect(status().isOk())
            .andExpect(view().name("Account"))
            .andExpect(view().name("Account"))
            .andExpect(model().attribute("transactions", hasSize(2)))
            .andExpect(model().attribute("account", hasProperty("accountEmail", is("test@gmail.com"))));

    Mockito.verify(depositService, Mockito.times(1)).getLoggedInUserAccount();
    Mockito.verify(transactionService, Mockito.times(1)).getRecentTransaction();

    Mockito.verifyNoMoreInteractions(depositService);
    Mockito.verifyNoMoreInteractions(transactionService);
  }

  @Test
  public void getDepositPage_returnSuccess() throws Exception {
    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");

    Mockito.when(depositService.getLoggedInUserAccount()).thenReturn(account);

    mockMvc.perform(get("/accounts/deposit"))
            .andExpect(status().isOk())
            .andExpect(view().name("Deposit"))
            .andExpect(forwardedUrl("Deposit"))
            .andExpect(model().attribute("account", hasProperty("accountEmail", is("test@gmail.com"))));

    Mockito.verify(depositService, Mockito.times(1)).getLoggedInUserAccount();
    Mockito.verifyNoMoreInteractions(depositService);
  }

  @Test
  public void deposit_returnRedirection() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    AccountTransactionRequest requestData = new AccountTransactionRequest(new BigDecimal(100), null, null);
    String request = objectMapper.writeValueAsString(requestData);

    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");
    account.setAccountBalance(200);

    Mockito.when(depositService.deposit(new BigDecimal(100))).thenReturn(account);

    mockMvc.perform(post("/accounts/deposit")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .content(request))
            .andExpect(status().is3xxRedirection());
  }

}
