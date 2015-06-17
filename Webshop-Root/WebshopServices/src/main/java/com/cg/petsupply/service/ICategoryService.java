/**
 * 
 */
package com.cg.petsupply.service;

import java.util.List;

import com.cg.petsupply.model.Category;

/**
 * @author ssukheja
 * Manage Category - Business Service APIs
 *
 */
public interface ICategoryService {
	
	/**
	 * Service method to save new or update existing category to database
	 * @param category
	 * @param userAction
	 * @return
	 */
	boolean saveCategory(Category category, String userAction);
	
	/**
	 * Service method to search and return all existing catgories
	 * @return
	 */
	List<Category> searchAllCategories();

	/**
	 * Service method to delete a category from database
	 * @param categoryId
	 * @return
	 */
	boolean deleteSingleCategory(Long categoryId);
	
	/**
	 * Service method to find and return requested category for edit
	 * @param categoryId
	 * @return
	 */
	Category getCategoryForEdit(Long categoryId);
}
