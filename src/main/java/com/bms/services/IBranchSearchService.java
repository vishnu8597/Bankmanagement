package com.bms.services;

import com.bms.model.IfscSearch;

/**
 * Purpose of this interface is to implement abstract methods for BranchSearchService class
 * Filename: IBranchSearchService.java
 *
 * @author: Anish Devineni
 */

public interface IBranchSearchService {

  boolean verifyIfsc(IfscSearch ifscSearch);

}
