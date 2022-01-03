package com.bms.services;

import com.bms.dao.ForgotDAO;
import com.bms.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForgotServiceTest {

  @Mock
  ForgotDAO forgotDAO;

  @InjectMocks
  ForgotService forgotService;

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

    String email = "Jainesh@dal.ca";

    Customer customer = new Customer();
    customer.setEmail(email);
    customer.setPassword("1234");

    List<Customer> list = new ArrayList();
    list.add(customer);

    when(forgotDAO.findByName(email)).thenReturn(list);

    List response = forgotService.findByName(email);

    assertEquals(1, response.size());
  }

}
