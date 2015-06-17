/**
 * 
 */
package com.cg.petsupply.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petsupply.model.Product;
import com.cg.petsupply.repository.IProductRepository;
import com.cg.petsupply.service.IProductService;

/**
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
	
	public Product getProductForEdit(Long productId){
		
		return productRepository.getProductForEdit(productId);
	}
	
	public boolean saveProduct(Product product, String userAction) {

		if(userAction.equalsIgnoreCase("add"))
			product.setCreatedDt(new Date());
		else
			product.setModifiedDt(new Date());
			
		return productRepository.saveProduct(product, userAction);
	}
}
