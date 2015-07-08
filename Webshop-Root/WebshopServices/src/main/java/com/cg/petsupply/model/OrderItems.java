/**
 * 
 */
package com.cg.petsupply.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * This Entity maps to table OrderItems in DB
 * 
 * @author ssukheja
 * 
 */

@Entity
public class OrderItems implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long orderItemsId;

	@NotNull
	private Long prodQuantity;

	@NotNull
	private Double price;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product products;

	/**
	 * @return the orderItemsId
	 */
	public Long getOrderItemsId() {
		return orderItemsId;
	}

	/**
	 * @param orderItemsId
	 *            the orderItemsId to set
	 */
	public void setOrderItemsId(Long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	/**
	 * @return the prodQuantity
	 */
	public Long getProdQuantity() {
		return prodQuantity;
	}

	/**
	 * @param prodQuantity
	 *            the prodQuantity to set
	 */
	public void setProdQuantity(Long prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the products
	 */
	public Product getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(Product products) {
		this.products = products;
	}

}
