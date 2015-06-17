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

import com.cg.petsupply.model.Product;
import com.cg.petsupply.repository.IProductRepository;

/**
 * @author ssukheja
 *
 */

@Repository("productrepository")
public class ProductRepositoryImpl implements IProductRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public boolean saveProduct(Product product, String action) {

		if (action.equalsIgnoreCase("add") && checkDuplicateProduct(product))
			return false;
		
		else if (action.equalsIgnoreCase("add"))
			entityManager.persist(product);
		
		else if (action.equalsIgnoreCase("edit")) 
			entityManager.merge(product);
		
		return true;		
	}

	
	public List<Product> searchAllProducts() {

		return entityManager.createNamedQuery("selectAllProducts",Product.class)
				.getResultList();
	}

	@Transactional
	public boolean deleteSingleProduct(Long productId) {

		entityManager.createNamedQuery("deleteSingleProduct").setParameter("paramProductId", productId).executeUpdate();
		return true;

	}

	public Product getProductForEdit(Long productId) {

		return entityManager.find(Product.class, productId);
	}

	
	private boolean checkDuplicateProduct(Product product) {

		Query query = entityManager.createNamedQuery("checkProductExists", Product.class);
		query.setParameter("prodName", product.getProductName());
		query.setParameter("prodId", product.getCategory().getCategoryId());

		@SuppressWarnings("unchecked")
		List<Product> existingProductList = query.getResultList();

		if (null != existingProductList && existingProductList.size() > 0)
			return true;

		return false;
	}

}
