package com.verification_team.controller;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.verification_team.dao.RegisterDAO;
import com.verification_team.model.Registration;

@Controller
public class AdminController {

	@Autowired
	RegisterDAO regDao;
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException{
		 HttpSession session= request.getSession(false);
	        SecurityContextHolder.clearContext();
	        if(session != null) {
	            session.invalidate();

	        }
	        	ModelAndView model = new ModelAndView("login");

		model.addObject("printme","SHASHIKUMAR !!");
		return model;
	}
	
	
	@RequestMapping(value="/login_page", method = RequestMethod.POST)
	public ModelAndView login_page(@ModelAttribute("registration") Registration registration) throws IOException{

        //System.out.println("................................" + registration.getReg_email());
		//regDao.insert(registration);
		Registration rego = regDao.login_check(registration);

		System.out.println("==========ddd========" +  rego.getReg_username() + "************" +  rego.getReg_password());
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value="/registerhome", method = RequestMethod.POST)
	public ModelAndView registerhome(@ModelAttribute("registration") Registration registration) throws IOException{

    //System.out.println("................................" + registration.getReg_email());
		regDao.insert(registration);
		ModelAndView model = new ModelAndView("login");
		return model;
	}

}
