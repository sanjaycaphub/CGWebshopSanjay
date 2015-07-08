/**
 * 
 */
package com.cg.petsupply.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petsupply.model.CustomerOrder;
import com.cg.petsupply.model.OrderItems;
import com.cg.petsupply.model.Product;
import com.cg.petsupply.model.User;
import com.cg.petsupply.repository.IOrderRepository;
import com.cg.petsupply.repository.IUserRepository;
import com.cg.petsupply.service.IOrderService;
import com.cg.petsupply.service.IProductService;


/**
 * Implementation of the business services declared in IOrderService
 * @author ssukheja
 *
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private IUserRepository userRepository;

	private static final Logger log = Logger.getLogger(OrderServiceImpl.class);

	public CustomerOrder createCheckoutOrder(Map<Long, Long> cartInSession,
			User loginUser) {
		
		List<OrderItems> orderItemsList = prepareOrderItems(cartInSession);
		CustomerOrder order = new CustomerOrder();		
		order.setOrderItems(orderItemsList);

		if (loginUser != null) {
			order.setShippingAddress(loginUser.getStreetAddress());
			order.setShippingCity(loginUser.getCity());
			order.setShippingZip(loginUser.getZip());
			order.setUsers(loginUser);
		}

		Iterator<OrderItems> iterator = orderItemsList.iterator();
		double orderAmountTotal = 0;
		while (iterator.hasNext()) {
			orderAmountTotal += iterator.next().getPrice();
		}
		order.setAmountTotal(orderAmountTotal);
		log.info("Final Order Amount Total is " + order.getAmountTotal());
		return order;
	}
	
	public Long submitOrder(CustomerOrder order, Map<Long, Long> productsCart){
		if(order.getUsers() == null)			
			order.setUsers(userRepository.findGuestUser());
		
		order.setOrderItems(prepareOrderItems(productsCart));
		return orderRepository.submitOrder(order);
	}
	
	private List<OrderItems> prepareOrderItems(Map<Long, Long> productsCart) {
		List<OrderItems> orderItemsList = new ArrayList<OrderItems>();
		OrderItems ordItem = null;

		Set<Map.Entry<Long, Long>> sessionCart = productsCart.entrySet();
		for (Map.Entry<Long, Long> me : sessionCart) {
			ordItem = new OrderItems();
			Product tempProduct = productService.searchProductById(me.getKey());
			tempProduct.setQuantity(me.getValue());
			ordItem.setProdQuantity(tempProduct.getQuantity());
			ordItem.setPrice(tempProduct.getQuantity()
					* tempProduct.getPrice());
			log.info("Price based on quantity added is " + ordItem.getProdQuantity());
			ordItem.setProducts(tempProduct);
			orderItemsList.add(ordItem);
		}
		return orderItemsList;
	}
}
