/**
 * 
 */
package com.cg.petsupply.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.petsupply.model.User;
import com.cg.petsupply.repository.IUserRepository;
import com.cg.petsupply.service.IUserService;

/**
 * Implementation of the business services declared in IUserService
 * @author ssukheja
 *
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	public User authenticateAdminAndUser(String userName, String password, String userRole) {

		if (userName != null && password != null) {
			List<User> authenticatedList = userRepository.authenticateAdminAndUser(userName, password, userRole);
			if (authenticatedList.size() > 0)
				return authenticatedList.get(0);			
		}
		return null;
	}
	
	public boolean addNewUser(User user){
		user.setIsAdmin("N");
		user.setCreatedDt(new Date());
		return userRepository.addNewUser(user);
	}
}