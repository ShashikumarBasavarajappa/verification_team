package com.verification_team.controller;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

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
}
