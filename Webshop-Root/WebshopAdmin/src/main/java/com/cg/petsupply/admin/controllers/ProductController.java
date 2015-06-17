/**
 * 
 */
package com.cg.petsupply.admin.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.petsupply.admin.utils.Constants;
import com.cg.petsupply.admin.utils.SessionValidateUtil;
import com.cg.petsupply.model.Category;
import com.cg.petsupply.model.Product;
import com.cg.petsupply.service.ICategoryService;
import com.cg.petsupply.service.IProductService;

/**
 * @author ssukheja Request controller for admin to manage Products
 */

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	private static final Logger log = Logger
			.getLogger(ProductController.class);

	/**
	 * Handler Mapping/Method for Admin to add new Product
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addproduct.htm", method = RequestMethod.GET)
	public String addProduct(ModelMap model, HttpServletRequest request) {

		if(SessionValidateUtil.invalidSession(request))
			return "login";
		
		log.info("Starting to add new Product now");

		model.addAttribute("productForm", new Product());

		List<Category> selectCategoryList = categoryService
				.searchAllCategories();
		model.addAttribute("selectCategoryList", selectCategoryList);
		return "addproduct";
	}

	/**
	 * Handler Mapping/Method to provide list of all existing products
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/allproducts.htm", method = RequestMethod.GET)
	public String showAllProducts(ModelMap model, HttpServletRequest request) {

		if(SessionValidateUtil.invalidSession(request))
			return "login";
		
		log.info("Showing all Products ");

		model.addAttribute("productList", productService.searchAllProducts());
		return "productList";
	}

	/**
	 * Handler Mapping/Method to handle delete product action by Admin
	 * 
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deletesingleproduct.htm", method = RequestMethod.GET)
	public String deleteSingleProduct(
			@RequestParam(value = "prodId", required = true) Long productId,
			ModelMap model, HttpServletRequest request) {

		if(SessionValidateUtil.invalidSession(request))
			return "login";
		
		log.info("Deleting product, Id paramater is -- " + productId);

		if (productService.deleteSingleProduct(productId))
			model.addAttribute("prodDelMsg", Constants.productDeleteSuccess);

		model.addAttribute("productList", productService.searchAllProducts());
		return "productList";
	}

	/**
	 * Handler Mapping/Method to provide products details for edit
	 * 
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editsingleproduct.htm", method = RequestMethod.GET)
	public String getProductForEdit(
			@RequestParam(value = "prodId", required = true) Long productId,
			ModelMap model, HttpServletRequest request) {

		if(SessionValidateUtil.invalidSession(request))
			return "login";
		
		log.info("Editing Product, Id paramater is -- " + productId);		
		
		model.addAttribute("productForm", productService.getProductForEdit(productId));		
		model.addAttribute("selectCategoryList", categoryService.searchAllCategories());
		return "editproduct";
	}

	/**
	 * Handler Mapping/Method to handle Save product Action by Admin for new products and update existing products
	 * 
	 * @param product
	 * @param result
	 * @param errors
	 * @param userAction
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveproduct.htm", method = RequestMethod.POST)
	public String onSubmitSaveProduct(
			@ModelAttribute(value = "productForm") @Valid Product product,
			BindingResult result, @RequestParam(value = "userAction") String userAction,
			ModelMap model, HttpServletRequest request) {

		if(SessionValidateUtil.invalidSession(request))
			return "login";
		
		log.info("Starting to save product now--" + userAction);
		
		model.addAttribute("selectCategoryList", categoryService.searchAllCategories());

		if (result.hasErrors() && userAction.equalsIgnoreCase("add"))
			return "addproduct";

		else if (result.hasErrors() && userAction.equalsIgnoreCase("edit"))
			return "editproduct";		

		if (userAction.equalsIgnoreCase("add") && productService.saveProduct(product, userAction))
			model.addAttribute("saveProductMsg", product.getProductName()+Constants.productAddSuccess);

		else if (userAction.equalsIgnoreCase("edit") && productService.saveProduct(product, userAction)) {
			model.addAttribute("saveProductMsg", product.getProductName()+Constants.productEditSuccess);
			return "editproduct";
		}

		else
			result.rejectValue("productName", "productName.exist",
					Constants.productExists);

		return "addproduct";
	}

}// End of Controller
