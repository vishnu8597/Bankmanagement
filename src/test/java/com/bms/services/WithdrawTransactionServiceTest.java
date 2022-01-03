package com.bms.services;

import com.bms.controller.LoginController;
import com.bms.dao.WithdrawTransactionDAO;
import com.bms.model.SavingsAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WithdrawTransactionServiceTest {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  WithdrawTransactionDAO withdrawTransactionDAO;

  @Mock
  LoginController loginController;

  @InjectMocks
  WithdrawTransactionService withdrawTransactionService;

  @BeforeEach
  public void setup() {
    HttpServletRequest mockRequest = new MockHttpServletRequest();
    ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(mockRequest);
    RequestContextHolder.setRequestAttributes(servletRequestAttributes);
    MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  public void teardown() {
    RequestContextHolder.resetRequestAttributes();
  }

  /**
   * Test case for findbyname()
   */
  @Test
  void findByNameTest() {

    String name = "Jainesh@dal.ca";

    SavingsAccount savingsAccount = new SavingsAccount();
    savingsAccount.setAccountEmail(name);
    List<SavingsAccount> list = new ArrayList();
    list.add(savingsAccount);

    when(withdrawTransactionDAO.findByName(name)).thenReturn(list);

    List response = withdrawTransactionService.findByName(name);

    assertEquals(1, response.size());
  }
}