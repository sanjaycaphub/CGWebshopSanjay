/**
 * 
 */
package com.cg.petsupply.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.petsupply.model.Category;
import com.cg.petsupply.model.Product;
import com.cg.petsupply.repository.ICategoryRepository;

/**  
 * Manage Categories - Implementation of ICategoryRepository APIs
 * @author ssukheja
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
	
	@Cacheable("cachedCategories")
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

		
		return query.getResultList().size() > 0;

		
		/*if (null!=existingCategoryList && existingCategoryList.size() > 0)
			return true;
		else
			return false;*/
	}
	
	
	private boolean checkProductsInCategory(Long categoryId){
		
		Query query = entityManager
				.createNamedQuery("productexistsincategory",Product.class);
		query.setParameter("catId", categoryId);	
		return query.getResultList().size() > 0;
		
		/*if (null!=productList && productList.size() > 0)
			return true;
		else
			return false;*/
	}

}
