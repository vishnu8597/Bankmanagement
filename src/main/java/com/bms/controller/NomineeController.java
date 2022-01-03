package com.bms.controller;

import com.bms.dao.NomineeDAO;
import com.bms.model.Nominee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;
/**
 * This class manages the operations related to Nominee.
 * Filename: NomineeController.java
 *
 * @author: Jainesh Ketan Desai
 */

@Controller
public class NomineeController {

  @Autowired
  NomineeDAO nomineeDAO;

  @GetMapping("/Nominee")
  public String getNominee() {

    return "Nominee";
  }


  /*
   * method to add Nominee
   * @param model: passing model object
   * @param name: passing name of the Nominee
   * @param relation: passing relation of Nominee
   * @return: html page
   * @throws SQLException
   */
  @PostMapping("/Nominee")
  public String addNominee(Model model,
                           @RequestParam("name") String name,
                           @RequestParam("relation") String relation) throws SQLException {

    System.out.println("in nominee");
    List<Nominee> list = nomineeDAO.findByEmail(LoginController.Email);
    System.out.println(list.size());
    int num=list.size();

    if (num > 0) {

      model.addAttribute("name", "Nominee already exits");


    } else {
      nomineeDAO.insert(new Nominee(name, relation, LoginController.Email));
      model.addAttribute("name", "Nominee Added into your profile");

    }
    return "Nominee";
  }

  /*
   * method to Delete Nominee from user accounts
   * @return: returns Nominee page
   * @throws SQLException
   */
  @PostMapping("/Nominee/delete")
  public String deleteNominee(Model model) throws SQLException {


    nomineeDAO.delete(LoginController.Email);
    model.addAttribute("rep", "Records for the Nominee has been deleted");
    return "Nominee";
  }



}


