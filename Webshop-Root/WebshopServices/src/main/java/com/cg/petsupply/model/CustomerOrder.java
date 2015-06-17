/**
 * 
 */
package com.cg.petsupply.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author ssukheja
 * This Entity maps to table CustomerOrder in DB
 */

@Entity
public class CustomerOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue
	private Long orderId;

	private Long orderNum;

	private String status;

	@NotNull
	private Double amountTotal;

	@NotNull
	private String shippingAddress;

	@NotNull
	private String shippingCity;

	@NotNull
	private Long shippingZip;

	private Date createdDt;
		
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<OrderItems> orderItems = new ArrayList<OrderItems>();
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User users;

	/**
	 * @return the ordersId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param ordersId the ordersId to set
	 */
	public void setOrdersId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderNum
	 */
	public Long getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the amountTotal
	 */
	public Double getAmountTotal() {
		return amountTotal;
	}

	/**
	 * @param amountTotal the amountTotal to set
	 */
	public void setAmountTotal(Double amountTotal) {
		this.amountTotal = amountTotal;
	}

	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the shippingCity
	 */
	public String getShippingCity() {
		return shippingCity;
	}

	/**
	 * @param shippingCity the shippingCity to set
	 */
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	/**
	 * @return the shippingZip
	 */
	public Long getShippingZip() {
		return shippingZip;
	}

	/**
	 * @param shippingZip the shippingZip to set
	 */
	public void setShippingZip(Long shippingZip) {
		this.shippingZip = shippingZip;
	}

	/**
	 * @return the createdDt
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt the createdDt to set
	 */
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the users
	 */
	public User getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(User users) {
		this.users = users;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
