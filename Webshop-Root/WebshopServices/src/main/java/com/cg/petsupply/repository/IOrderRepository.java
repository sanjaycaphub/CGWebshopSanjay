/**
 * 
 */
package com.cg.petsupply.repository;

import com.cg.petsupply.model.CustomerOrder;

/**
 * Order Repository / DAO APIs
 * @author ssukheja
 *
 */
public interface IOrderRepository {

	/**
	 * Repository method to save users order to database for order fulfillment
	 * @param order
	 * @return
	 */
	Long submitOrder(CustomerOrder order);
}
