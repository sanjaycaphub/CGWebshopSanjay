/**
 * 
 */
package com.cg.petsupply.admin.utils;

/**
 * @author sanjay
 * 
 */
public final class Constants {

	private Constants() {
	}

	public static final String PROPERTY_NAME_DATABASE_DRIVER = "org.h2.Driver";
	public static final String PROPERTY_NAME_DATABASE_URL = "jdbc:h2:file:D:/Sanjay/PetSupplyDB/H2_DB;AUTO_SERVER=TRUE";
	public static final String PROPERTY_NAME_DATABASE_USERNAME = "sa";
	public static final String PROPERTY_NAME_DATABASE_PASSWORD = "sa";
	public static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
	public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
	public static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "validate";
	public static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.cg.petsupply.model";

	// Messages
	public static final String wrongAdminCredentials = "Incorrect username or password, please try again";

	public static final String categoryAddSuccess = " - Category added successfully";
	public static final String categoryEditSuccess = " - Category updated successfully";
	public static final String categoryExists = " Category already exists";
	public static final String categoryDeleteSuccess = " Category deleted Successfully";
	public static final String categoryDeleteFail = "Cannot delete category - Products are attached to the category";

	public static final String productAddSuccess = " - Product added successfully";
	public static final String productEditSuccess = " - Product updated successfully";
	public static final String productExists = "Product in this Category already exists";
	public static final String productDeleteSuccess = "Product Deleted Successfully";

	// Return Views
	public static final String returnHome = "home";
	public static final String returnLogin = "login";
	public static final String returnAddCategory = "addcategory";
	public static final String returnEditCategory = "editcategory";
	public static final String returnCategoryList = "categoryList";
	public static final String returnAddProduct = "addproduct";
	public static final String returnEditProduct = "editproduct";
	public static final String returnProductList = "productList";
}
