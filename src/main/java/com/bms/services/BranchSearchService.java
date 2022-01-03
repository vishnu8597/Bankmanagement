package com.bms.services;

import com.bms.dao.BranchSearchDao;
import com.bms.model.BranchSearch;
import com.bms.model.IfscSearch;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Purpose of this class is hold the business logic to validate whether the correct IFSC code
 * is entered by the user
 * Filename: BranchSearchService.java
 *
 * @author: Anish Devineni
 */

public class BranchSearchService implements IBranchSearchService {

  private final BranchSearchDao branchSearchDao;

  @Autowired
  public BranchSearchService() {
    this.branchSearchDao = new BranchSearchDao();
  }

  public boolean verifyIfsc(IfscSearch ifscSearch) {
    List<BranchSearch> resultset = branchSearchDao.checkifsc(ifscSearch);
    return resultset.size() != 0;
  }
}