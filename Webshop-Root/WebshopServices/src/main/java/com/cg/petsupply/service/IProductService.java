/**
 * 
 */
package com.cg.petsupply.service;

import java.util.List;
import com.cg.petsupply.commons.utils.ProductSearchVO;
import com.cg.petsupply.model.Product;


/**
 * Business Service APIs for Manage Product by Admin and Searching/Shopping products by End Users  
 * @author ssukheja
 * 
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
	 * Service method to find and return requested product based on Product Id
	 * @param productId
	 * @return
	 */
	Product searchProductById(Long productId);
	
	/**
	 * Service method to find and return products based on users search criteria (Sprint 2)
	 * @param searchVO
	 * @return
	 */
	List<Product> searchProducts(ProductSearchVO searchVO);	
	
}
