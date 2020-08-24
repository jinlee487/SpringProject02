package com.green.SpringProject02.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.SpringProject02.dao.UserRepository;
import com.green.SpringProject02.error.UserAlreadyExistException;
import com.green.SpringProject02.model.UserDTO;
import com.green.SpringProject02.model.UserVO;
import com.green.SpringProject02.security.MyUserDetails;
import com.green.SpringProject02.service.MService;

@Controller
public class MemberController {
	 private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	 
	@Autowired
	MService service;
	
	@RequestMapping("/admin/mlist")
	public ModelAndView mlist(ModelAndView mv) {
		List<UserVO> list = service.findAll();
		mv.addObject("list",list);
		mv.setViewName("/member/memberList");
		return mv;
	} // mlist
	@RequestMapping("/user/detail")
	public ModelAndView detail(ModelAndView mv, final Authentication authentication, UserVO vo, HttpServletRequest request) {
       System.out.println("thsi is request principal => " + request.getUserPrincipal());

		System.out.println("this is principal => " + authentication.getPrincipal());
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	
//		System.out.println("this is userDetail => " + userDetails);
		String userName = authentication.getName();
		vo = service.findByUserName(userName);
		System.out.println("this is vo => \n" + vo);
		mv.addObject("user",vo);
		mv.setViewName("/member/memberDetail");
		return mv;
	} // mlist
	@GetMapping("/registration")
	public ModelAndView showRegistrationForm(ModelAndView mv) {
		mv.setViewName("/member/joinForm");
	    return mv;
	}
	@PostMapping(value="/registration")
	public ModelAndView registerUserAccount(ModelAndView mv, @Valid final UserDTO userDTO, final HttpServletRequest request, final Errors errors) {
		LOGGER.debug("Registering user account with information: {}", userDTO);
		mv.setViewName("/member/doFinish");
        try {
            final UserVO registered = service.registerNewUserAccount(userDTO);
            System.out.println("this user has been registered! => \n" +registered);
        } catch (final UserAlreadyExistException uaeEx) {
            mv.addObject("fCode", "DF");
            mv.addObject("message", "An account for that username/email already exists.");
            System.out.println("UserAlreadyExistException");
            return mv;
        } catch (final RuntimeException ex) {
            LOGGER.warn("Unable to register user", ex);
            System.out.println("RuntimeException");

            mv.addObject("fCode", "DF");
            mv.addObject("emailError", "Unable to register user");
            return mv;
        }
        mv.addObject("fCode", "JS");
        
        return mv;
	}
//	@GetMapping("/registration")
//	public ModelAndView showRegistrationForm(ModelAndView mv, UserDTO userDTO) {
//		mv.setViewName("/thymeleaf/registeration");
//		mv.addObject("user", userDTO);
//	    return mv;
//	}
//	@PostMapping(value="/registration")
//	public ModelAndView registerUserAccount(ModelAndView mv, @Valid final UserDTO userDTO, final HttpServletRequest request, final Errors errors) {
//		LOGGER.debug("Registering user account with information: {}", userDTO);
//		mv.setViewName("/member/doFinish");
//        try {
//            final UserVO registered = service.registerNewUserAccount(userDTO);
//            System.out.println("this user has been registered! => \n" +registered);
//        } catch (final UserAlreadyExistException uaeEx) {
//            mv.addObject("fCode", "DF");
//            mv.addObject("message", "An account for that username/email already exists.");
//            System.out.println("UserAlreadyExistException");
//            return mv;
//        } catch (final RuntimeException ex) {
//            LOGGER.warn("Unable to register user", ex);
//            System.out.println("RuntimeException");
//
//            mv.addObject("fCode", "DF");
//            mv.addObject("emailError", "Unable to register user");
//            return mv;
//        }
//        mv.addObject("fCode", "JS");
//        
//        return mv;
//	}
	
}
