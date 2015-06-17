package com.cg.petsupply.repository;

import java.util.List;

import com.cg.petsupply.model.Product;

/**
 * @author ssukheja
 * Manage Product - Repository / DAO APIs
 *
 */
public interface IProductRepository {

	
	/**
	 * Repository method to save new or update existing product to database
	 * @param product
	 * @param action
	 * @return
	 */
	boolean saveProduct(Product product, String action);
	
	
	/**
	 * Repository method to search and return all existing products
	 * @return
	 */
	List<Product> searchAllProducts();
	
	
	
	/**
	 * Repository method to delete a product from database
	 * @param productId
	 * @return
	 */
	boolean deleteSingleProduct(Long productId);
	
	
	/**
	 * Repository method to find and return requested product for edit
	 * @param productId
	 * @return
	 */
	Product getProductForEdit(Long productId);
	
}
