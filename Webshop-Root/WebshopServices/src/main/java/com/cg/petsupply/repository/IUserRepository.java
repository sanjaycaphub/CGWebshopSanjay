/**
 * 
 */
package com.cg.petsupply.repository;

import java.util.List;

import com.cg.petsupply.model.User;

/**
 * Repository APIs for Authentication and registering new user to Store
 * @author ssukheja 
 *
 */
public interface IUserRepository {

	
	/**
	 * Repository method to authenticate user
	 * @param userName
	 * @param password
	 * @param userRole
	 * @return
	 */
	List<User> authenticateAdminAndUser(String userName, String password, String userRole);
	
	/**
	 * Repository method to add new user to petsupplies store database (Sprint 2)
	 * @param user
	 * @return
	 */
	boolean addNewUser(User user);
	
	/**
	 * @return
	 */
	User findGuestUser();
}
