/**
 * 
 */
package com.cg.petsupply.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author ssukheja
 * This Entity maps to table Product in DB
 */

@NamedQueries({
	@NamedQuery(name="selectAllProducts", query="select p from Product p"),
	@NamedQuery(name="deleteSingleProduct", query="delete from Product p where p.productId = :paramProductId"),
	@NamedQuery(name="checkProductExists", query="select p from Product p where upper(p.productName) "
						+ "like upper(:prodName) and p.category.categoryId = :prodId")
})
@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long productId;

	@NotEmpty(message = "Product Name is required field")
	@Length(max = 255, message = "Limit to number of characters for name is 255")
	private String productName;

	private Double price;

	@Length(max = 255, message = "Limit to number of characters for description is 255")
	private String description;

	private Date createdDt;

	private Date modifiedDt;

	@ManyToOne
	@JoinColumn(name = "categoryId")	
	private Category category;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
