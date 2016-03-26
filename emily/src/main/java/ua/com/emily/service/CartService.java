package ua.com.emily.service;

import java.util.List;


import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Product;

/**
 * Service interface for {@link Cart}s.
 * 
 * @author Tanskiy R.
 */

public interface CartService {

	/**
	 * Saves the given {@link Cart}.
	 * 
	 * @param product, countProduct, session
	 *
	 */
	
	void createCart(Product product, int countProduct, String session);
	/**
	 * Returns all {@link Cart}s.
	 * 
	 * @return
	 */
	
	List<Cart> getAllCarts();
	
	/**
	 * Returns all {@link Cart}s of the given {CartsSession}.
	 * 
	 * @param Session
	 * @return
	 */
	
	List<Cart> getCartsSession(String s);
	
	/**
	 * Returns {@link Cart} of the given idCart.
	 * 
	 * @param idCart
	 * @return
	 */
	Cart findByIdCart(int idCart);
	/**
	 * Returns {@link Cart}s of the given Session.
	 * 
	 * @param Session
	 * @return
	 */
	Cart findBySession(String s);
	/**
	 * Delete {@link Cart}s of the given idCart.
	 * 
	 * @param idCart
	 * 
	 */
	void deleteCart(int idCart);
	
	/**
	 * Update {@link Cart}s of the given idCart.
	 * 
	 * @param idCart, product, countProduct
	 * 
	 */
	
	void updateCart(int idCart, Product product, int countProduct);
	
	void confirmCart(int idCart);
	
	
}
