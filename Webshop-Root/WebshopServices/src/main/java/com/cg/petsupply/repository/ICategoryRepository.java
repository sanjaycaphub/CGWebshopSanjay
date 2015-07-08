/**
 * 
 */
package com.cg.petsupply.repository;

import java.util.List;

import com.cg.petsupply.model.Category;

/**
 * Manage Category - Repository / DAO APIs
 * @author ssukheja
 * 
 */


public interface ICategoryRepository {

	/**
	 * Repository method to save new or update existing category to database
	 * @param category
	 * @param userAction
	 * @return
	 */
	boolean saveCategory(Category category, String userAction);
	
	
	/**
	 * Repository method to search and return all existing catgories
	 * @return
	 */
	List<Category> searchAllCategories();
	
	/**
	 * Repository method to delete a category from database
	 * @param categoryId
	 * @return
	 */
	boolean deleteSingleCategory(Long categoryId);
	
	
	
	/**
	 * Repository method to find and return requested category for edit
	 * @param categoryId
	 * @return
	 */
	Category getCategoryForEdit(Long categoryId);
}
