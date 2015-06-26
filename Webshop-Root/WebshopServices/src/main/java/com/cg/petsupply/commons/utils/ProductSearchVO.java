package com.cg.petsupply.commons.utils;

/**
 * 
 */

/**
 * @author ssukheja
 *
 */
public class ProductSearchVO {

	private String prodName;

	private String prodDesc;

	private Long categoryId;

	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName
	 *            the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * @return the prodDesc
	 */
	public String getProdDesc() {
		return prodDesc;
	}

	/**
	 * @param prodDesc
	 *            the prodDesc to set
	 */
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

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
}
