/**
 * 
 */
package com.cg.petsupply.admin.controllers;

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
import com.cg.petsupply.service.ICategoryService;

/**
 * Request controller for admin to manage Categories
 * 
 * @author ssukheja
 */

@Controller
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	private static final Logger log = Logger
			.getLogger(CategoryController.class);

	/**
	 * Handler Mapping/Method for Admin to add new category
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addcategory.htm", method = RequestMethod.GET)
	public String addCategory(ModelMap model, HttpServletRequest request) {

		if (SessionValidateUtil.invalidSession(request))
			return Constants.returnLogin;

		log.info("Starting to add new Category");

		model.addAttribute("categoryForm", new Category());
		return Constants.returnAddCategory;
	}

	/**
	 * Handler Mapping/Method to provide list of all existing categories
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/allcategories.htm", method = RequestMethod.GET)
	public String showAllCategories(ModelMap model, HttpServletRequest request) {

		if (SessionValidateUtil.invalidSession(request))
			return Constants.returnLogin;

		log.info("Showing all categories");

		model.addAttribute("catList", categoryService.searchAllCategories());
		return Constants.returnCategoryList;

	}

	/**
	 * Handler Mapping/Method to handle delete category action by Admin
	 * 
	 * @param categoryId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deletesinglecategory.htm", method = RequestMethod.GET)
	public String deleteSingleCategory(
			@RequestParam(value = "catId", required = true) Long categoryId,
			ModelMap model, HttpServletRequest request) {

		if (SessionValidateUtil.invalidSession(request))
			return Constants.returnLogin;

		log.info("Deleting Category, Id paramater is -- " + categoryId);

		if (categoryService.deleteSingleCategory(categoryId))
			model.addAttribute("catDelMsg", Constants.categoryDeleteSuccess);
		else
			model.addAttribute("catDelMsg", Constants.categoryDeleteFail);

		model.addAttribute("catList", categoryService.searchAllCategories());
		return Constants.returnCategoryList;
	}

	/**
	 * Handler Mapping/Method to provide category details for edit
	 * 
	 * @param categoryId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editsinglecategory.htm", method = RequestMethod.GET)
	public String getCategoryForEdit(
			@RequestParam(value = "catId", required = true) Long categoryId,
			ModelMap model, HttpServletRequest request) {

		if (SessionValidateUtil.invalidSession(request))
			return Constants.returnLogin;

		log.info("Editing Category, Id paramater is -- " + categoryId);

		model.addAttribute("categoryForm",
				categoryService.getCategoryForEdit(categoryId));
		return Constants.returnEditCategory;
	}

	/**
	 * Handler Mapping/Method to handle Save Category Action by Admin for new
	 * categories and update existing categories
	 * 
	 * @param category
	 * @param result
	 * @param errors
	 * @param model
	 * @param userAction
	 * @return
	 */
	@RequestMapping(value = "/savecategory.htm", method = RequestMethod.POST)
	public String onSubmitSaveCategory(
			@ModelAttribute(value = "categoryForm") @Valid Category category,
			BindingResult result, ModelMap model, HttpServletRequest request,
			@RequestParam(value = "userAction") String userAction) {

		if (SessionValidateUtil.invalidSession(request))
			return Constants.returnLogin;

		log.info("Starting to save category now " + userAction);

		if (result.hasErrors())
			return Constants.returnAddCategory;

		else if (userAction.equalsIgnoreCase("add")
				&& categoryService.saveCategory(category, userAction))
			model.addAttribute("saveCategoryMsg", category.getCategoryName()
					+ Constants.categoryAddSuccess);

		else if (userAction.equalsIgnoreCase("edit")
				&& categoryService.saveCategory(category, userAction)) {
			model.addAttribute("saveCategoryMsg", category.getCategoryName()
					+ Constants.categoryEditSuccess);
			return Constants.returnEditCategory;
		} else
			result.rejectValue("categoryName", "categoryName.exist",
					Constants.categoryExists);

		return Constants.returnAddCategory;
	}

}// End Of Controller

