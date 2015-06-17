/**
 * 
 */
package com.cg.petsupply.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.petsupply.model.Category;
import com.cg.petsupply.model.Product;
import com.cg.petsupply.repository.ICategoryRepository;

/**
 * @author ssukheja
 * Manage Categories - Implementation of Repository APIs
 *
 */

@Repository("categoryRepository")
public class CategoryRepositoryImpl implements ICategoryRepository {

	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
	public boolean saveCategory(Category category, String userAction) {

		if (userAction.equalsIgnoreCase("add") && checkDuplicateCategory(category.getCategoryName()))
			return false;
		
		else if (userAction.equalsIgnoreCase("add"))
			entityManager.persist(category);
		
		else if (userAction.equalsIgnoreCase("edit"))
			entityManager.merge(category);
			
		return true;		
	}
	
	
	public List<Category> searchAllCategories(){
		
		return entityManager.createNamedQuery("selectAllCategories",Category.class).getResultList();	
	}
	
	@Transactional
	public boolean deleteSingleCategory(Long categoryId){
				
		if(checkProductsInCategory(categoryId))
			return false;
		else
			entityManager.createNamedQuery("deleteSingleCategory").setParameter("paramCategoryId", categoryId).executeUpdate();
			
		return true;
	}
	
	public Category getCategoryForEdit(Long categoryId){
		
		return entityManager.find(Category.class, categoryId);		
	}

	
	private boolean checkDuplicateCategory(String categoryName) {
		 
		Query query = entityManager
				.createNamedQuery("checkCategoryExists",Category.class);
		query.setParameter("catName", categoryName);

		@SuppressWarnings("unchecked")
		List<Category> existingCategoryList = query.getResultList();

		if (null!=existingCategoryList && existingCategoryList.size() > 0)
			return true;
		else
			return false;
	}
	
	
	private boolean checkProductsInCategory(Long categoryId){
		
		Query query = entityManager
				.createNamedQuery("productexistsincategory",Product.class);
		query.setParameter("catId", categoryId);	
		
		@SuppressWarnings("unchecked")
		List<Product> productList = query.getResultList();

		if (null!=productList && productList.size() > 0)
			return true;
		else
			return false;
	}

}
