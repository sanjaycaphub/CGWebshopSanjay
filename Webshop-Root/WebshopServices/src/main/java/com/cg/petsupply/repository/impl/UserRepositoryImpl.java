/**
 * 
 */
package com.cg.petsupply.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.petsupply.model.User;
import com.cg.petsupply.repository.IUserRepository;

/**
 * @author ssukheja
 *
 */

@Repository("userRepository")
public class UserRepositoryImpl implements IUserRepository {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.cg.petsupply.repository.IUserRepository#authenticateUser(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<User> authenticateUser(String userName, String password, String userRole) {
		
		Query query = em.createQuery("select u from User u where lower(u.userName) like lower(:username) and u.password like :passwd "
									+ "and u.userRole like :userrole");
		query.setParameter("username", userName); 
		query.setParameter("passwd", password);
		query.setParameter("userrole", userRole);
		
		return query.getResultList();		
	}

}
