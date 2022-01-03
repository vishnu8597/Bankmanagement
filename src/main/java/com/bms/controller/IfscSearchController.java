package com.bms.controller;

import com.bms.dao.BranchSearchDao;
import com.bms.model.BranchSearchDetails;
import com.bms.model.IfscSearch;
import com.bms.services.BranchSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Purpose of this class is to function as a controller for IFSC search functionality
 * Filename: IfscSearchController.java
 *
 * @author: Anish Devineni
 */

@Controller
public class IfscSearchController {

  private final BranchSearchService branchSearchService;

  @Autowired
  public IfscSearchController() {
    this.branchSearchService = new BranchSearchService();
  }

  @GetMapping("/branch")
  public String details(String ifsc, Model model, BranchSearchDao branchSearchDao, @ModelAttribute BranchSearchDetails branchSearchDetails) {
    String[] branch = branchSearchDao.ifscSearch(ifsc);
    model.addAttribute("branchname", "");
    model.addAttribute("address", "");
    model.addAttribute("phonenumber", "");
    return "BranchDetails";
  }

  @PostMapping("/branches")
  public String searchifsc(@ModelAttribute IfscSearch ifscSearch, Model model, HttpServletResponse httpServletResponse, BranchSearchDao branchSearchDao) throws SQLException, IOException {
    if (branchSearchService.verifyIfsc(ifscSearch)) {
      String[] branch = branchSearchDao.ifscSearch(ifscSearch.getIfsccode());
      model.addAttribute("branchname", branch[0]);
      model.addAttribute("address", branch[1]);
      model.addAttribute("phonenumber", branch[2]);
      return "BranchDetails";
    } else {
      return "invalidifsccode";
    }
  }
}
