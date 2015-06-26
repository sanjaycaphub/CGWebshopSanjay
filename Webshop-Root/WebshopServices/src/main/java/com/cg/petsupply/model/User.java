package com.cg.petsupply.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This Entity maps to table User in DB
 * 
 * @author ssukheja
 * 
 */
@NamedQueries({
		@NamedQuery(name = "authenticateAdmin", query = "select u from User u where lower(u.userName) like lower(:username) and u.password like :passwd "
				+ "and u.isAdmin like :isadmin"),
		@NamedQuery(name = "authenticateUser", query = "select u from User u where lower(u.userName) like lower(:username) and u.password like :passwd") })
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long userId;

	@NotEmpty(message = "Username is a required field")
	@Length(max = 100, message = "Number of characters for UserName cannot exceed 100")
	private String userName;

	@Length(min = 8, message = "Password should be minimum 8 characters in length")
	private String password;

	private String isAdmin;

	@NotEmpty(message = "First Name is a required field")
	@Length(max = 100, message = "Number of characters for First Name cannot exceed 100")
	private String firstName;

	@NotEmpty(message = "Last Name is a required field")
	@Length(max = 100, message = "Number of characters for Last Name cannot exceed 100")
	private String lastName;

	@Email
	private String email;

	@NotEmpty(message = "Please enter your residence Street Address")
	private String streetAddress;

	@NotEmpty(message = "Please enter your residence city")
	private String city;

	@NotEmpty(message = "Please enter your residence zipcode")
	private String zip;

	private Date createdDt;

	private Date modifiedDt;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
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
	 * @param userName
	 *            the userName to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isAdmin
	 */
	public String getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress
	 *            the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the createdDt
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt
	 *            the createdDt to set
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
	 * @param modifiedDt
	 *            the modifiedDt to set
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
	 * @param orderList
	 *            the orderList to set
	 */
	public void setOrderList(List<CustomerOrder> orderList) {
		this.orderList = orderList;
	}
}
