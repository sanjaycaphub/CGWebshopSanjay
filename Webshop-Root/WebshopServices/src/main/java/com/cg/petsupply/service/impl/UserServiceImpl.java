/**
 * 
 */
package com.cg.petsupply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petsupply.model.User;
import com.cg.petsupply.repository.IUserRepository;
import com.cg.petsupply.service.IUserService;

/**
 * @author ssukheja
 *
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cg.petsupply.service.IUserService#authenticateUser(java.lang.String,
	 * java.lang.String)
	 */
	public User authenticateUser(String userName, String password, String userRole) {

		if (userName != null && password != null) {
			List<User> authenticatedList = userRepository.authenticateUser(userName, password, userRole);
			if (authenticatedList.size() > 0)
				return authenticatedList.get(0);			
		}
		return null;
	}
}