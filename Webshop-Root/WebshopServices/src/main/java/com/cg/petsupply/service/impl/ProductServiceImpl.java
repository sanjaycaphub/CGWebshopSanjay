/**
 * 
 */
package com.cg.petsupply.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petsupply.commons.utils.ProductSearchVO;
import com.cg.petsupply.model.Product;
import com.cg.petsupply.repository.IProductRepository;
import com.cg.petsupply.service.IProductService;

/**
 * Implementation of the business services declared in IProductService
 * @author ssukheja
 *
 */

@Service("productservices")
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;	

	public List<Product> searchAllProducts() {
		return productRepository.searchAllProducts();
	}

	public boolean deleteSingleProduct(Long productId) {

		return productRepository.deleteSingleProduct(productId);
	}
	
	public Product searchProductById(Long productId){
		
		return productRepository.searchProductById(productId);
	}
	
	public boolean saveProduct(Product product, String userAction) {

		if(userAction.equalsIgnoreCase("add"))
			product.setCreatedDt(new Date());
		else
			product.setModifiedDt(new Date());
			
		return productRepository.saveProduct(product, userAction);
	}
	
	public List<Product> searchProducts(ProductSearchVO searchVO){
		return productRepository.searchProducts(searchVO);
	}
	
}
