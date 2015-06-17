/**
 * 
 */
package com.cg.petsupply.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petsupply.model.Category;
import com.cg.petsupply.repository.ICategoryRepository;
import com.cg.petsupply.service.ICategoryService;


/**
 * @author ssukheja
 *
 */

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	
	public List<Category> searchAllCategories(){
		return categoryRepository.searchAllCategories();
	}
	
	public boolean deleteSingleCategory(Long categoryId){
		
		return categoryRepository.deleteSingleCategory(categoryId);		
	}
	
	public Category getCategoryForEdit(Long categoryId){
		
		return categoryRepository.getCategoryForEdit(categoryId);
	}
	
	public boolean saveCategory(Category category, String userAction) {
		
		if(userAction.equalsIgnoreCase("add"))
			category.setCreatedDt(new Date());
		else
			category.setModifiedDt(new Date());
		
		return categoryRepository.saveCategory(category, userAction);
	}

}
