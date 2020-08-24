package com.green.SpringProject02.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/","/home"})
	public ModelAndView home(ModelAndView mv)
	{
		mv.setViewName("/home");
		return mv;
	}
	@RequestMapping("/home2")
	public ModelAndView home2(ModelAndView mv)
	{
		mv.setViewName("/home2");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView loginPage(ModelAndView mv) {
		mv.setViewName("/login");
		return mv;
	}
	@RequestMapping("/logout-success")
	public ModelAndView logoutPage(ModelAndView mv) {
		mv.setViewName("/logout");
		return mv;
	}	

}
