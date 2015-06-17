/**
 * 
 */
package com.cg.petsupply.users.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.petsupply.model.Product;

/**
 * @author ssukheja
 *
 */

@Controller
public class ProductController {
	
	@RequestMapping(value = "viewAllProducts", method = RequestMethod.GET)
	public List<Product> listAllProducts(String prodName){		
		return null;
	}
	
	@RequestMapping(value = "searchProducts", method = RequestMethod.GET)
	public List<Product> searchProducts(String prodName){		
		return null;
	}
	
	@RequestMapping(value = "viewProduct", method = RequestMethod.GET)
	public Product viewProduct(String prodId){
		return null;
	}
	
	@RequestMapping(value = "addProductToCart", method = RequestMethod.POST)
	public Long addProductToCart(){
		return null;
		
	}	
	
}
	
