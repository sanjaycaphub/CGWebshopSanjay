/**
 * 
 */
package com.cg.petsupply.users.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cg.petsupply.commons.utils.ProductSearchVO;
import com.cg.petsupply.model.Product;
import com.cg.petsupply.service.ICategoryService;
import com.cg.petsupply.service.IProductService;
import com.cg.petsupply.users.utils.Constants;

/**
 * Request controller to handle all requests related to Product Search, Add to
 * Cart, Remove from Cart and etc. It adds couple of attributes to session.
 * 
 * @author ssukheja, Sprint 2
 * 
 */

@Controller
@SessionAttributes({ "shoppingCartMap", "productSearchVO" })
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	private Map<Long, Long> shoppingCartMap = new HashMap<Long, Long>();

	private List<Product> cartProductsList;

	private static final Logger log = Logger.getLogger(ProductController.class);

	/**
	 * Handler/Mapping method when users request for Searching a product
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchproduct.htm", method = RequestMethod.GET)
	public String searchProduct(ModelMap model) {

		model.addAttribute("selectCategoryList",
				categoryService.searchAllCategories());
		return Constants.returnSearchProduct;
	}

	/**
	 * Handler/Mapping method for users product search request based on input
	 * search parameters. It calls search product service for the results
	 * 
	 * @param categoryId
	 * @param prodName
	 * @param prodDesc
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/productsearch.htm", method = RequestMethod.GET)
	public String listSearchedProducts(
			@RequestParam("selectcategory") String categoryId,
			@RequestParam(value = "prodname") String prodName,
			@RequestParam(value = "proddesc") String prodDesc, ModelMap model) {

		ProductSearchVO searchVO = new ProductSearchVO();
		searchVO.setCategoryId(Long.valueOf(categoryId));
		searchVO.setProdName(prodName);
		searchVO.setProdDesc(prodDesc);

		model.addAttribute("showProductsList",
				productService.searchProducts(searchVO));

		/* This time it will come from Cache, no DB query will be fired */
		model.addAttribute("selectCategoryList",
				categoryService.searchAllCategories());

		model.addAttribute("productSearchVO", searchVO);

		return Constants.returnSearchProduct;
	}

	/**
	 * Handler/Mapping method when users add product to cart. It stores Product
	 * ID and quantity map key value (then map in session) and displays product
	 * list back to user
	 * 
	 * @param productId
	 * @param quantity
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addtocart.htm", method = RequestMethod.GET)
	public String addToCart(@RequestParam("prodId") Long productId,
			@RequestParam("quantity") Long quantity, ModelMap model,
			HttpServletRequest request) {

		log.info("Product ID added to cart is " + productId + " Quantity is "
				+ quantity);

		@SuppressWarnings("unchecked")
		Map<Long, Long> cartInSession = (HashMap<Long, Long>) request
				.getSession().getAttribute("shoppingCartMap");
		
		if (null != cartInSession && cartInSession.containsKey(productId)) {
			Long newQuantity = this.getShoppingCartMap().get(productId)
					+ quantity;
			cartInSession.remove(productId);
			cartInSession.put(productId, newQuantity);
			model.addAttribute("cartaddemsg",
					Constants.addCartSuccessAlreadyExists);
		} 
		else if(null != cartInSession){			
				cartInSession.put(productId, quantity);
				model.addAttribute("cartaddemsg", Constants.cartAddSuccess);
		}
		else		
			{
			this.getShoppingCartMap().put(productId, quantity);
			model.addAttribute("shoppingCartMap", this.getShoppingCartMap());
			model.addAttribute("cartaddemsg", Constants.cartAddSuccess);
		}

		// Here Category List will be loaded from cache
		model.addAttribute("selectCategoryList",
				categoryService.searchAllCategories());

		ProductSearchVO searchVO = (ProductSearchVO) request.getSession()
				.getAttribute("productSearchVO");

		model.addAttribute("showProductsList",
				productService.searchProducts(searchVO));

		return Constants.returnSearchProduct;
	}

	/**
	 * Handler/Mapping method when users request to View their Shopping Cart.
	 * All ProductIDs stored in Session map will be searched from repository for
	 * product details
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewshoppingcart.htm", method = RequestMethod.GET)
	public String viewShoppingCart(HttpServletRequest request, ModelMap model) {

		@SuppressWarnings("unchecked")
		Map<Long, Long> cartInSession = (HashMap<Long, Long>) request
				.getSession().getAttribute("shoppingCartMap");

		if (cartInSession != null && cartInSession.size() > 0) {
			log.info("Cart In Session size is " + cartInSession.size());
			this.cartProductsList = new ArrayList<Product>();
			prepareCartList(this.cartProductsList);
			model.addAttribute("cartList", this.cartProductsList);
		}

		return Constants.returnShoppingCart;
	}

	/**
	 * Handler/Mapping method when users request to modify quantity of product
	 * in their shopping cart. It updates session map with new quantity
	 * 
	 * @param productId
	 * @param quantity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatecart.htm")
	public String modifyCart(@RequestParam("prodId") Long productId,
			@RequestParam("quantity") Long quantity, ModelMap model) {

		this.getShoppingCartMap().remove(productId);
		this.getShoppingCartMap().put(productId, quantity);
		model.addAttribute("cartupdatemsg", Constants.cartUpdateSuccess);

		if (this.getShoppingCartMap() != null
				&& this.getShoppingCartMap().size() > 0) {
			this.cartProductsList = new ArrayList<Product>();
			prepareCartList(this.cartProductsList);
			model.addAttribute("cartList", this.cartProductsList);
		}
		return Constants.returnShoppingCart;
	}

	/**
	 * Handler/Mapping method when users request to remove product from their shopping cart.
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/removefromcart.htm")
	public String removeFromCart(@RequestParam("prodId") Long productId,
			ModelMap model) {

		this.getShoppingCartMap().remove(productId);
		model.addAttribute("cartupdatemsg", Constants.cartRemoveSuccess);

		if (this.getShoppingCartMap() != null
				&& this.getShoppingCartMap().size() > 0) {
			this.cartProductsList = new ArrayList<Product>();
			prepareCartList(this.cartProductsList);
			model.addAttribute("cartList", this.cartProductsList);
		}
		return Constants.returnShoppingCart;
	}

	/**
	 * @param cartProductsList
	 */
	private void prepareCartList(List<Product> cartProductsList) {

		Set<Map.Entry<Long, Long>> sessionCart = this.shoppingCartMap
				.entrySet();
		for (Map.Entry<Long, Long> me : sessionCart) {
			Product tempProduct = productService.searchProductById(me.getKey());
			tempProduct.setQuantity(me.getValue());
			cartProductsList.add(tempProduct);
		}
	}

	/**
	 * @return the cartProductsList
	 */
	public List<Product> getCartProductsList() {
		return cartProductsList;
	}

	/**
	 * @param cartProductsList
	 *            the cartProductsList to set
	 */
	public void setCartProductsList(List<Product> cartProductsList) {
		this.cartProductsList = cartProductsList;
	}

	/**
	 * @return
	 */
	public Map<Long, Long> getShoppingCartMap() {
		return shoppingCartMap;
	}

	/**
	 * @param shoppingCartMap
	 */
	public void setShoppingCartMap(Map<Long, Long> shoppingCartMap) {
		this.shoppingCartMap = shoppingCartMap;
	}

}
