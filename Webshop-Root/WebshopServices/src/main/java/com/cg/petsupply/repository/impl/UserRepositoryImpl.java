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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.petsupply.repository.IUserRepository#authenticateUser(java.lang
	 * .String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<User> authenticateAdminAndUser(String userName,
			String password, String isAdmin) {
		Query query = null;
		if (isAdmin.equalsIgnoreCase("Y")) {
			query = em.createNamedQuery("authenticateAdmin");
			query.setParameter("isadmin", isAdmin);
		} else
			query = em.createNamedQuery("authenticateUser");

		query.setParameter("username", userName);
		query.setParameter("passwd", password);

		return query.getResultList();
	}

	@Transactional
	public boolean addNewUser(User user) {
		boolean returnVar = false;

		if (checkUserNameExists(user.getUserName())
				|| checkEmailExists(user.getEmail()))
			return returnVar;
		else {
			em.persist(user);
			returnVar = true;
		}

		return returnVar;
	}

	private boolean checkUserNameExists(String userName) {
		Query query = em
				.createQuery("select u from User u where lower(u.userName) like lower(:userName)");
		query.setParameter("userName", userName);
		return query.getResultList().size() > 0;
	}

	private boolean checkEmailExists(String email) {
		Query query = em
				.createQuery("select u from User u where lower(u.email) like lower(:email)");
		query.setParameter("email", email);
		return query.getResultList().size() > 0;
	}

}
