package com.cg.petsupply.repository;

import java.util.List;

import com.cg.petsupply.commons.utils.ProductSearchVO;
import com.cg.petsupply.model.Product;

/**
 * Repository APIs for Manage Product by Admin and Searching/Shopping products by End Users  
 * @author ssukheja
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
	 * Repository method to find and return requested product based on Product Id
	 * @param productId
	 * @return
	 */
	Product searchProductById(Long productId);
	
	/**
	 * Repository method to find and return products based on users search criteria (Sprint 2)
	 * @param searchVO
	 * @return
	 */
	List<Product> searchProducts(ProductSearchVO searchVO);	
	
}
