package com.elib.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.elib.entity.User;
import com.elib.service.UserService;

@Controller
public class HomeController {

  @Autowired
  private UserService userService;
  
  @RequestMapping(value = { "/elibrary" })
  public ModelAndView homeHandler(){
    User user = new User();
    return new ModelAndView("login");
  }
}
