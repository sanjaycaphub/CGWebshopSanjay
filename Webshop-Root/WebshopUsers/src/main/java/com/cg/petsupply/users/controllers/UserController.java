/**
 * 
 */
package com.cg.petsupply.users.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.petsupply.model.User;
import com.cg.petsupply.service.IUserService;
import com.cg.petsupply.users.utils.Constants;

/**
 * Request controller to handle all requests related to users signin, signup and
 * signout. Once user Signs In it adds one user object to session.
 * 
 * @author ssukheja
 * 
 */
@Controller
@SessionAttributes("loginUser")
public class UserController {

	@Autowired
	private IUserService userService;

	private static final Logger log = Logger.getLogger(UserController.class);

	/**
	 * Handler/Mapping method if users request to Sign Up with the petsupplies
	 * store
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/signup.htm")
	public String signUp(ModelMap model) {
		model.addAttribute("userForm", new User());
		return Constants.returnRegistration;
	}

	/**
	 * Handler/Mapping method when users complete registration form for Sign Up
	 * and submit the form. It calls services to store user details into
	 * database.
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registeruser.htm", method = RequestMethod.POST)
	public String registerUser(
			@ModelAttribute(value = "userForm") @Valid User user,
			BindingResult result, ModelMap model) {
		log.info("Ready to register user " + user.getEmail());

		if (result.hasErrors())
			return Constants.returnRegistration;

		if (userService.addNewUser(user))
			model.addAttribute("registerUserMsg", Constants.registrationSuccess);
		else
			model.addAttribute("registerUserMsg",
					Constants.registrationValidationFail);

		return Constants.returnRegistration;
	}

	/**
	 * Handler/Mapping method when user wants to Sign In
	 * 
	 * @return
	 */
	@RequestMapping("/signin.htm")
	public String showLogin() {
		return Constants.returnSignIn;
	}

	/**
	 * Handler/Mapping method to return to Home page
	 * 
	 * @return
	 */
	@RequestMapping("/home.htm")
	public String home() {
		return Constants.returnHome;
	}

	/**
	 * Handler/Mapping method to authenticate user when they Sign In to
	 * petsupplies estore using their credentials
	 * 
	 * @param model
	 * @param userName
	 * @param password
	 * @param isAdmin
	 * @return
	 */
	@RequestMapping(value = "/signin.htm", method = RequestMethod.POST)
	public String authenticateUser(Model model,
			@RequestParam(value = "username", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "isadmin") String isAdmin) {

		log.info("Parameters coming are--" + userName + " " + password);

		if (userName != null || password != null) {

			User loginUser = userService.authenticateAdminAndUser(userName,
					password, isAdmin);
			if (loginUser != null) {
				model.addAttribute("loginUser", loginUser);
				return Constants.returnHome;
			}
		}
		model.addAttribute("wrongLoginCredentials",
				Constants.wrongUserCredentials);
		return Constants.returnSignIn;
	}

	/**
	 * Handler/Mapping method to logout user from the store and empty their cart and session.
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("/signout.htm")
	public String logout(SessionStatus status, HttpServletRequest request) {

		status.setComplete();
		request.getSession().invalidate();
		log.info("Log Out Complete"
				+ request.getSession().getAttribute("shoppingCartMap"));
		log.info("Log Out Complete"
				+ request.getSession().getAttribute("loginUser"));
		return null;
	}
}
