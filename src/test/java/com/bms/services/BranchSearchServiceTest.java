package com.bms.services;

import com.bms.model.IfscSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchSearchServiceTest {

  private final IfscSearch ifscSearch = new IfscSearch();
//  BranchSearchService branchSearchService = new BranchSearchService();

  @Test
  void verifyIfscTrue() {
    ifscSearch.setIfsccode("BMS000001");
    BranchSearchService branchSearchService = new BranchSearchService();
    assertEquals( true, branchSearchService.verifyIfsc(ifscSearch));
  }

  @Test
  void verifyIfscFalse() {
   ifscSearch.setIfsccode("TESTIFSC01");
   BranchSearchService branchSearchService = new BranchSearchService();
   assertEquals( false, branchSearchService.verifyIfsc(ifscSearch));
  }
}