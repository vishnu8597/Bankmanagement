package com.bms.dao;

import com.bms.model.BranchSearch;
import com.bms.model.BranchSearchDetails;
import com.bms.model.IfscSearch;

import java.util.List;

/**
 * Purpose of this interface is to implement the abstract methods for the BranchSearchDao class
 * Filename: IBranchSearch.java
 *
 * @author: Anish Devineni
 */

public interface IBranchSearchDao {

  String branchSearch(BranchSearchDetails branchSearchDetails);

  String[] ifscSearch(String ifsc);

  List<BranchSearch> checkifsc(IfscSearch iFscSearch);

}
