package com.bms.services;

import com.bms.dao.IDepositDAO;
import com.bms.model.SavingsAccount;
import com.bms.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test cases for DepositServiceTest class
 * Filename : DepositServiceTest.java
 *
 * @author: Anjali Chaudhary
 */

public class DepositServiceTest {

  private IDepositDAO depositDAO;
  private HttpSession httpSession;
  private ITransactionService transactionService;
  private Transaction transaction;

  private DepositService depositService;

  @BeforeEach
  public void setUp() {
    depositDAO = Mockito.mock(IDepositDAO.class);
    httpSession = Mockito.mock(HttpSession.class);
    transactionService = Mockito.mock(ITransactionService.class);
    transaction = Mockito.mock(Transaction.class);

    depositService = new DepositService(depositDAO, httpSession, transactionService);
  }

  @Test
  public void getAccountByEmail_returnSuccess() {
    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");

    Mockito.when(depositDAO.findAccountDetailsByEmail("test@gmail.com")).thenReturn(account);

    SavingsAccount accountFromService = depositService.getAccountByEmail("test@gmail.com");

    assertEquals("test@gmail.com", accountFromService.getAccountEmail());
  }

  @Test
  public void getLoggedInUserAccount_returnSuccess() {
    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");

    String username = "test@gmail.com";

    Mockito.when(httpSession.getAttribute("username")).thenReturn(username);
    Mockito.when(depositService.getAccountByEmail(Mockito.anyString())).thenReturn(account);

    SavingsAccount accountFromService = depositService.getLoggedInUserAccount();

    assertEquals("test@gmail.com", accountFromService.getAccountEmail());
  }

  @Test()
  public void deposit_userNotPresent_throwException() throws Exception {
    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");
    account.setAccountBalance(100);

    String username = "test2@gmail.com";

    Mockito.when(httpSession.getAttribute("username")).thenReturn(username);
    Mockito.when(depositService.getAccountByEmail("test@gmail.com")).thenReturn(account);

    assertThrows(Exception.class, () -> {
      depositService.deposit(new BigDecimal(5));
    });

  }

  @Test
  public void deposit_returnSuccess() throws Exception {
    SavingsAccount account = new SavingsAccount();
    account.setAccountEmail("test@gmail.com");
    account.setAccountBalance(100);

    String username = "test@gmail.com";

    Mockito.when(httpSession.getAttribute("username")).thenReturn(username);
    Mockito.when(depositService.getAccountByEmail(Mockito.anyString())).thenReturn(account);

    Mockito.when(depositDAO.updateAccount(account)).thenReturn(account);

    PowerMockito.whenNew(Transaction.class).withAnyArguments().thenReturn(transaction);

    SavingsAccount updatedAccount = depositService.deposit(new BigDecimal(5));
    assertEquals(105, updatedAccount.getAccountBalance());

  }

}
