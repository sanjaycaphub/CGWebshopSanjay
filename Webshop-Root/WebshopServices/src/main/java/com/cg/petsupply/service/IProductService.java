/**
 * 
 */
package com.cg.petsupply.service;

import java.util.List;

import com.cg.petsupply.model.Product;

/**
 * @author ssukheja
 * Manage Product - Business Service APIs
 */
public interface IProductService {

	/**
	 * Service method to save new or update existing product to database
	 * @param product
	 * @param userAction
	 * @return
	 */
	boolean saveProduct(Product product, String userAction);	
	
	/**
	 * Service method to search and return all existing products
	 * @return
	 */
	List<Product> searchAllProducts();
	
	/**
	 * Service method to delete a product from database
	 * @param productId
	 * @return
	 */
	boolean deleteSingleProduct(Long productId);
	
	/**
	 * Service method to find and return requested product for edit
	 * @param productId
	 * @return
	 */
	Product getProductForEdit(Long productId);
}
