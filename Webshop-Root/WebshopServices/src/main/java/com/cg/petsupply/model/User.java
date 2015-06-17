package com.cg.petsupply.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ssukheja
 * This Entity maps to table User in DB
 */

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long userId;

	@NotEmpty(message="Username is a required field")
	private String userName;

	@NotEmpty(message="Password is a required field")
	private String password;
	
	private String userRole;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private String emailAddress;

	private String address;

	private String city;

	private Long zip;

	private Date createdDt;

	private Date modifiedDt;
	
	@OneToMany(mappedBy="users", cascade=CascadeType.ALL)
	private List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public Long getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(Long zip) {
		this.zip = zip;
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
	 * @return the modifiedDt
	 */
	public Date getModifiedDt() {
		return modifiedDt;
	}

	/**
	 * @param modifiedDt the modifiedDt to set
	 */
	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the orderList
	 */
	public List<CustomerOrder> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<CustomerOrder> orderList) {
		this.orderList = orderList;
	}

	
}
