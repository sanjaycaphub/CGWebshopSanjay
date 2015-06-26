/**
 * 
 */
package com.cg.petsupply.users.utils;

/**
 * @author sanjay
 * 
 */
public class Constants {

	 private Constants(){}
	
	public static final String PROPERTY_NAME_DATABASE_DRIVER = "org.h2.Driver";
	public static final String PROPERTY_NAME_DATABASE_URL = "jdbc:h2:file:D:/Sanjay/PetSupplyDB/H2_DB;AUTO_SERVER=TRUE";
	public static final String PROPERTY_NAME_DATABASE_USERNAME = "sa";
	public static final String PROPERTY_NAME_DATABASE_PASSWORD = "sa";     
	public static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
	public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
	public static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "create";
	public  static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.cg.petsupply.model";

	//Messages
	
	public static final String registrationError = "Errors on Page";
	public static final String registrationSuccess = "User Registered Successfully";
	public static final String registrationValidationFail = "User with same Username and/or Email already exist. Please re-register.";
	public static final String cartAddSuccess = "Product added to Cart successfully";
	public static final String cartUpdateSuccess = "Cart updated successfully";
	public static final String cartRemoveSuccess = "Product removed from cart successfully";
	public static final String addCartSuccessAlreadyExists = "Product already present in Cart. Quantity added successfully";
	//Return Views
	public static final String returnRegistration = "registration";
	public static final String returnSearchProduct = "searchproduct";
	public static final String returnShoppingCart = "shoppingCart";
	public static final String returnBrowseCategory = "browsecategory";
	
	public static final String returnHome = "home";
	public static final String returnSignIn = "signin";	
	public static final String wrongUserCredentials = "Incorrect login credentials. Please try again.";
}
