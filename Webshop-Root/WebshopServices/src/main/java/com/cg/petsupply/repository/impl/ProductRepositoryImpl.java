/**
 * 
 */
package com.cg.petsupply.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.petsupply.commons.utils.ProductSearchVO;
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

		return entityManager.createNamedQuery("selectAllProducts",
				Product.class).getResultList();
	}

	@Transactional
	public boolean deleteSingleProduct(Long productId) {

		entityManager.createNamedQuery("deleteSingleProduct")
				.setParameter("paramProductId", productId).executeUpdate();
		return true;

	}

	public Product searchProductById(Long productId) {

		return entityManager.find(Product.class, productId);
	}

	private boolean checkDuplicateProduct(Product product) {

		Query query = entityManager.createNamedQuery("checkProductExists",
				Product.class);
		query.setParameter("prodName", product.getProductName());
		query.setParameter("prodId", product.getCategory().getCategoryId());

		return query.getResultList().size() > 0;

		/*
		 * if (null != existingProductList && existingProductList.size() > 0)
		 * return true;
		 * 
		 * return false;
		 */
	}

	
	@SuppressWarnings("unchecked")
	public List<Product> searchProducts(ProductSearchVO searchVO) {
		Query query = prepareCriteriaQuery(searchVO);
		List<Product> tempList = query.getResultList();
		System.out.println("Size of list is--- " + tempList.size());
		return tempList;
	}

	/*
	 * private Query prepareSearchProductQuery(Long categoryId, String
	 * prodName){
	 * 
	 * Query query = null;
	 * 
	 * if(categoryId==0 && !prodName.equals("")){ query =
	 * entityManager.createNamedQuery("searchprodinallcategory",Product.class);
	 * query.setParameter("prodName", "%"+prodName+"%"); } else if(categoryId!=0
	 * && prodName.equalsIgnoreCase("")){ query =
	 * entityManager.createNamedQuery("searchallprodsincategory",Product.class);
	 * query.setParameter("catId", categoryId); } else{ query =
	 * entityManager.createNamedQuery("searchprodincategory",Product.class);
	 * query.setParameter("prodName", "%"+prodName+"%");
	 * query.setParameter("catId", categoryId); } return query; }
	 */

	@SuppressWarnings({"rawtypes", "unchecked" })
	private Query prepareCriteriaQuery(ProductSearchVO searchVO) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(Product.class);

		Root productRoot = cq.from(Product.class);
		List<Predicate> whereClauseList = new ArrayList<Predicate>();

		if (searchVO.getCategoryId() != 0) {
			Predicate predicate1 = cb.equal(
					productRoot.get("category").get("categoryId"), searchVO.getCategoryId());
			whereClauseList.add(predicate1);
		}

		if (!searchVO.getProdName().equals("")) {
			Predicate predicate2 = cb.like(cb.lower(productRoot.get("productName")),"%"+searchVO.getProdName().toLowerCase()+"%");
					
			whereClauseList.add(predicate2);
		}
		
		if(!searchVO.getProdDesc().equals("")){			
			Predicate predicate3= cb.like(cb.lower(productRoot.get("description")), "%"+searchVO.getProdDesc().toLowerCase()+"%");
			whereClauseList.add(predicate3);
		}
		

		cq.where(cb.and(whereClauseList.toArray(new Predicate[0])));

		return entityManager.createQuery(cq);

	}

}
