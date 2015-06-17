/**
 * 
 */
package com.cg.petsupply.service;

import com.cg.petsupply.model.User;

/**
 * @author ssukheja
 * Manage Users - Business Service APIs
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
	User authenticateUser(String userName, String password, String userRole);
	
}
