package com.verification_team.controller;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.verification_team.dao.RegisterDAO;
import com.verification_team.model.Book;
import com.verification_team.model.Registration;
import com.verification_team.model.Verification_date;

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
	public String  login_page(@ModelAttribute("registration") Registration registration,HttpSession session, RedirectAttributes rr) throws IOException{

        //System.out.println("................................" + registration.getReg_email());
		//regDao.insert(registration);
		Registration rego = regDao.login_check(registration);

		System.out.println("==========ddd========" +  rego.getReg_username() + "************" +  rego.getReg_password());
		//ModelAndView model = new ModelAndView("login");
		//return model
	//	if((registration.getReg_username().equals(rego.getReg_username())) && (registration.getReg_password().equals(rego.getReg_password()))){
				rr.addAttribute("username", rego.getReg_username());
				return "redirect:/admin_welcomepage";
		//}else{
			//return "redirect:/";
		//}
		}

	@RequestMapping(value="/registerhome", method = RequestMethod.POST)
	public ModelAndView registerhome(@ModelAttribute("registration") Registration registration) throws IOException{

    //System.out.println("................................" + registration.getReg_email());
		regDao.insert(registration);
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value="/admin_welcomepage")
	public ModelAndView admin_welcomepage(HttpServletRequest req, HttpServletResponse response,RedirectAttributes rrr, HttpSession session, RedirectAttributes shashi_session) throws IOException{
		String username  =  req.getParameter("username");
		
		
		List<Verification_date> rego = regDao.verification_data_list(username);
		
		ModelAndView model = new ModelAndView("welcome");
		
		
	    model.addObject("main_user_name", username);
	    model.addObject("verification_data", rego);
	    
		return model;
	}

	@RequestMapping(value="/submit_my_data", method = RequestMethod.POST)
	public String submit_my_data(@ModelAttribute("verification_date") Verification_date verification_date,HttpSession session, RedirectAttributes rr) throws IOException{

		System.out.println("======================" +  verification_date.getCas_id() + "===" + verification_date.getApplicant_status() + "========" + verification_date.getStart_date() + "========" + verification_date.getEnd_date());
		  regDao.insert_verification_data(verification_date);
		rr.addAttribute("username", verification_date.getUsername());
		return "redirect:/admin_welcomepage";
	}
	
	@RequestMapping(value="/download_excel_data/{username}",method = RequestMethod.GET)
	public ModelAndView getExcel(HttpSession session,HttpServletRequest request, HttpServletResponse response,@PathVariable String username) throws ServletRequestBindingException {
		System.out.println("*******************" + username);
		//return new ModelAndView("AnimalListExcel", "animalList", animalList);
		///String username  =  req.getParameter("username");		
       List<Verification_date> rego = regDao.verification_data_list(username);
   	List<Verification_date> listBooks = new ArrayList<Verification_date>();
	listBooks.add(new Verification_date("Effective Java", "Joshua Bloch", "0321356683","May 28, 2008", "dasdsad"));
	listBooks.add(new Verification_date("Head First Java", "Kathy Sierra & Bert Bates","0596009208", "February 9, 2005", "dsadsad"));
	
	// return a view which will be resolved by an excel view resolver
	return new ModelAndView("excelView", "listBooks", rego);

/*
		ModelAndView model = new ModelAndView("welcome");
		
		
	    model.addObject("main_user_name", username);
	    model.addObject("verification_data", rego);
	    
		return model;
*/
	}
	 @RequestMapping(value="/logout",method = RequestMethod.GET)
     public String logout(HttpServletRequest request){

		 request.getSession(false).invalidate();
     HttpSession httpSession = request.getSession();
      httpSession.invalidate();
         return "redirect:/";
  }

}
