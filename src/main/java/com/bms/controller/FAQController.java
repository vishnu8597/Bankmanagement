package com.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Purpose of this class is function as a controller for FAQ module
 * Filename: FAQController
 *
 * @author: Jagadeeswara Aditya Busam
 */

@Controller
public class FAQController {

  @GetMapping("/FAQs")
  public String displayFAQ() {
    return "FrequentlyAskedQuestions";
  }

}