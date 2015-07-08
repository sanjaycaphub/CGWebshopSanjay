/**
 * 
 */
package com.cg.petsupply.users.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.petsupply.model.CustomerOrder;
import com.cg.petsupply.model.User;
import com.cg.petsupply.service.IOrderService;
import com.cg.petsupply.users.utils.Constants;

/**
 * Request controller to handle requests related to Order Checkout and Submit Order 
 * @author ssukheja
 *
 */

@Controller
public class OrderController {

	@Autowired
	private IOrderService orderService;

	private static final Logger log = Logger.getLogger(OrderController.class);

	
	/**
	 * Handler/Mapping that processes proceed to Checkout request from user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/proceedcheckout.htm", method=RequestMethod.GET)
	public String proceedCheckout(ModelMap model, HttpServletRequest request) {
		log.info("Proceeding to Checkout. Will create Order for Customer");
		@SuppressWarnings("unchecked")
		Map<Long, Long> cartInSession = (HashMap<Long, Long>) request
				.getSession().getAttribute("shoppingCartMap");
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		if (cartInSession == null || cartInSession.size() == 0) {
			model.addAttribute("additemstocart", Constants.plzAddItemsToCart);
			return Constants.returnShoppingCart;
		} else {
			CustomerOrder order = orderService.createCheckoutOrder(
					cartInSession, loginUser);
			model.addAttribute("userorder", order);			
		}
		return Constants.returnCheckout;
	}
	
	
	/**
	 * Handler/Mapping that accepts the users order submission request
	 * @param order
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/submitorder.htm", method=RequestMethod.POST)
	public String submitOrder(@ModelAttribute(value="userorder") @Valid CustomerOrder order, BindingResult result,
			HttpServletRequest request, ModelMap model) {		
		log.info("Submitting Order "+order.getAmountTotal());
		if(result.hasErrors())
			return Constants.returnCheckout;
		else{
			User loginUser = (User) request.getSession().getAttribute("loginUser");
			order.setUsers(loginUser);
			@SuppressWarnings("unchecked")
			Map<Long, Long> cartInSession = (HashMap<Long, Long>) request
					.getSession().getAttribute("shoppingCartMap");
			Long newOrderId = orderService.submitOrder(order, cartInSession);			
			model.addAttribute("newOrderMsg", Constants.orderSuccess+newOrderId.toString());
			cartInSession.clear();
		}	
		return Constants.returnCheckout;
	}
}
