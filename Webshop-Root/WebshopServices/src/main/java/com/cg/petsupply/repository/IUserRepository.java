/**
 * 
 */
package com.cg.petsupply.repository;

import java.util.List;

import com.cg.petsupply.model.User;

/**
 * @author ssukheja
 * Manage Users - Repository / DAO APIs
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
	List<User> authenticateUser(String userName, String password, String userRole);
}
