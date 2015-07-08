/**
 * 
 */
package com.cg.petsupply.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.petsupply.model.CustomerOrder;
import com.cg.petsupply.repository.IOrderRepository;

/**
 * Implementation of IOrderRepository APIs
 * @author ssukheja
 *
 */

@Repository("orderRepository")
public class OrderRepositoryImpl implements IOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Long submitOrder(CustomerOrder order) {
	
		entityManager.persist(order);
		return order.getOrderId();
		
	}

}
