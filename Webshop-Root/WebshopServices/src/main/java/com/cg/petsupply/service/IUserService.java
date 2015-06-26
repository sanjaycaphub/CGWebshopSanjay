/**
 * 
 */
package com.cg.petsupply.service;

import com.cg.petsupply.model.User;

/**
 * Business Service APIs for Authentication and registering new user to Store
 * @author ssukheja 
 *
 */
public interface IUserService {

	/**
	 * Service method to authenticate user
	 * @param userName
	 * @param password
	 * @param userRole
	 * @return
	 */
	User authenticateAdminAndUser(String userName, String password, String isAdmin);	
	
	
	/**
	 * Service method add/register new user to petsupplies store (Sprint 2)
	 * @param user
	 * @return
	 */
	boolean addNewUser(User user);
	
}
