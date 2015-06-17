/**
 * 
 */
package com.cg.petsupply.admin.controllers;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.petsupply.admin.utils.Constants;
import com.cg.petsupply.model.User;
import com.cg.petsupply.service.IUserService;

/**
 * @author ssukheja
 * Request Controller for Webshop Admin Authentication
 */

@Controller
@SessionAttributes("loginUser")
public class LoginController {

	@Autowired
	private IUserService userService;
	
	private static final Logger log = Logger
			.getLogger(LoginController.class);

	/**
	 * Handler Mapping/Method to authenticate user is admin or not
	 * @param model
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login.htm")
	public String authenticateUser(Model model,
			@RequestParam(value = "username", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "userrole") String userRole) {

		log.info("Parameters coming are--" + userName + " "
				+ password);

		if (userName != null || password != null) {

			User loginUser = userService.authenticateUser(userName, password, userRole);
			if (loginUser != null) {
				model.addAttribute("loginUser", loginUser);
				return "home";
			}			
		}
			model.addAttribute("wrongLoginCredentials", Constants.wrongAdminCredentials);
			return "login";
	}
	
	/**
	 * For Returning to home screen 
	 * @return
	 */
	@RequestMapping("/home.htm")
	public String goHome(){
		log.info("Returning to Home");
		return "home";
	}
	
	/**
	 * Logout admin from webshop
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout.htm")
	public String logout(SessionStatus status, HttpServletRequest request){
		
		log.info("Logging Out");
		status.setComplete();
		request.getSession().invalidate();	
		log.info("Log Out Complete");
		return "login";
	}
}
