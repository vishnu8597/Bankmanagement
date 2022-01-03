package com.bms.services;

import com.bms.dao.NomineeDAO;
import com.bms.model.Nominee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NomineeServiceTest {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  NomineeDAO nomineeDAO;

  @InjectMocks
  NomineeService nomineeService;

  /**
   * Test case for findbyname()
   */
  @Test
  void findByNameTest() {

    String email = "Jainesh@dal.ca";

    Nominee nominee = new Nominee();
    nominee.setName("jainesh");
    nominee.setEmail(email);
    nominee.setId(1);
    nominee.setRelantionship("brother");

    List<Nominee> list = new ArrayList();
    list.add(nominee);

    when(nomineeDAO.findByEmail(email)).thenReturn(list);

    List response = nomineeService.findByEmail(email);

    assertEquals(1, response.size());
  }

}
