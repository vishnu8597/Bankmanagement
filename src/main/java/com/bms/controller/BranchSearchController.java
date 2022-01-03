package com.bms.controller;

import com.bms.dao.BranchSearchDao;
import com.bms.model.BranchSearchDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for branch search functionality
 * Filename: BranchSearchController.java
 *
 * @author: Anish Devineni
 */

@Controller
public class BranchSearchController {

  @GetMapping("/Search")
  public String branchSearch(Model model) {
    model.addAttribute("ifsc", "");
    return "Search";
  }

  @PostMapping("/branchsearch") //Adding account Homepage for future
  public String searchBranch(@ModelAttribute BranchSearchDao branchSearchDao, BranchSearchDetails branchSearchDetails, Model model) throws SQLException {
    String ifsc = branchSearchDao.branchSearch(branchSearchDetails);
    model.addAttribute("ifsc", ifsc);
    return "Search";
  }
}
