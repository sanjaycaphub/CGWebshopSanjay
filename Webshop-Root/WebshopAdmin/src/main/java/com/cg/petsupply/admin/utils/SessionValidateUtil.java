/**
 * 
 */
package com.cg.petsupply.admin.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ssukheja
 *
 */
public class SessionValidateUtil {

	public static boolean invalidSession(HttpServletRequest request) {

		return (request.getSession().getAttribute("loginUser") == null);
	}
}
