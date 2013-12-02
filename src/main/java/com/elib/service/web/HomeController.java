package com.elib.service.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elib.dao.BookDAO;
import com.elib.entity.Book;
import com.elib.entity.User;
import com.elib.service.UserService;
import com.elib.tools.util.Constants;

@Controller
public class HomeController {

  @Autowired
  private BookDAO bookDAO;
  @Autowired
  private UserService userService;

  @RequestMapping(value = { "/login" })
  public String logIn(@RequestParam("email") String email, @RequestParam("password") String password) {
    User user = userService.logIn(email, password);
    System.out.println(user);
    if (user != null) {
      return "/profile";
    } else {
      return "/home";
    }
  }

  @RequestMapping(value = { "/register" })
  public String register(@RequestParam("fName") String fName, @RequestParam("lName") String lName,
          @RequestParam("email") String email, @RequestParam("password") String password) {
    Map<String, Object> map = new HashMap<String, Object>();
    System.out.println(email + password);
    map.put(Constants.USER_FIRSTNAME_KEY, fName);
    map.put(Constants.USER_LASTNAME_KEY, lName);
    map.put(Constants.USER_EMAIL_KEY, email);
    map.put(Constants.USER_PASSWORD_KEY, password);
    map.put(Constants.USER_DATE_OF_BIRTHD_KEY, new Date());
    if (userService.register(map) != null) {
      return "/profile";
    } else {
      return "/home";
    }
  }
  
  @RequestMapping(value = { "/search" })
  public Model search(@RequestParam("str") String str, Model model){
    if (!str.isEmpty()){
      System.out.println(str);
      return model.addAttribute(bookDAO.findByAll(str));
    } else {
      return model;
    }
  }

}