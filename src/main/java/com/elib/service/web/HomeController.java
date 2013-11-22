package com.elib.service.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping(value = { "/elibrary" })
  public ModelAndView homeHandler(){
    return new ModelAndView("login");
  }
}
