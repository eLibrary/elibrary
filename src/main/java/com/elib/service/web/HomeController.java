package com.elib.service.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elib.entity.User;
import com.elib.service.UserService;
import com.elib.tools.util.Constants;

@Controller
public class HomeController{

  @Autowired
  private UserService userService;

  @RequestMapping(value = { "/login" })
  public ModelAndView logIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
    User user = userService.logIn(email, password);
    System.out.println(user);
    if (user != null) {
      return new ModelAndView("profile");
    } else {
      return new ModelAndView("home");
    }
  }

  @RequestMapping(value = { "/register" })
  public ModelAndView register(@RequestParam("fName") String fName, @RequestParam("lName") String lName,
          @RequestParam("email") String email, @RequestParam("password") String password) {
    Map<String, Object> map = new HashMap<String, Object>();
    System.out.println(email + password);
    map.put(Constants.USER_FIRSTNAME_KEY, fName);
    map.put(Constants.USER_LASTNAME_KEY, lName);
    map.put(Constants.USER_EMAIL_KEY, email);
    map.put(Constants.USER_PASSWORD_KEY, password);
    map.put(Constants.USER_DATE_OF_BIRTHD_KEY, new Date());
    if (userService.register(map) != null) {
      return new ModelAndView("redirect:/profile");
    } else {
      return new ModelAndView("home");
    }
  }

}
