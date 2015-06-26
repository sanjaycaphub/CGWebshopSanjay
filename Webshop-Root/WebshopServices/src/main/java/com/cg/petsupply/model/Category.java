package com.cg.petsupply.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This Entity maps to table Category in DB
 * @author ssukheja
 */

@NamedQueries({
		@NamedQuery(name = "selectAllCategories", query = "select c from Category c"),
		@NamedQuery(name = "deleteSingleCategory", query = "delete from Category c where c.categoryId = :paramCategoryId"),
		@NamedQuery(name = "checkCategoryExists", query = "select c from Category c where upper(c.categoryName) like upper(:catName)"),
		@NamedQuery(name = "productexistsincategory", query = "select p from Product p where p.category.categoryId like :catId") })
@Entity
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long categoryId;

	@NotEmpty(message = "Category Name is required field")
	@Length(max = 255, message = "Limit to number of characters for name is 255")
	private String categoryName;

	@Length(max = 255, message = "Limit to number of characters for description is 255")
	private String categoryDesc;

	private Date createdDt;

	private Date modifiedDt;

	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the catergoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the catergoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryDesc
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}

	/**
	 * @param categoryDesc
	 *            the categoryDesc to set
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
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

}
