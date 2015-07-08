/**
 * 
 */
package com.cg.petsupply.service;

import java.util.Map;

import com.cg.petsupply.model.CustomerOrder;
import com.cg.petsupply.model.User;

/**
* Business Service APIs for Order of Products by End Users  
* @author ssukheja
* 
*/
public interface IOrderService {
	
	/**
	 * Service method to create users order from the users cart
	 * @param productsCart
	 * @param loginUser
	 * @return
	 */
	CustomerOrder createCheckoutOrder(Map<Long, Long> productsCart, User loginUser);
	
	/**
	 * Service Method to submit Users order
	 * @param order
	 * @param productsCart
	 * @return
	 */
	Long submitOrder(CustomerOrder order, Map<Long, Long> productsCart);
}
