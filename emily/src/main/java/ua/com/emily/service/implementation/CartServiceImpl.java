package ua.com.emily.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.emily.dao.CartDao;
import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Product;
import ua.com.emily.service.CartService;

/**
 * Plain JPA implementation of {@link CartService}.
 * 
 * @author Tanskiy R.
 */

@Service("cartService")
public class CartServiceImpl implements CartService{

	
	
	@Autowired
	private CartDao dao;
	
	

	public CartDao getDao() {
		return dao;
	}

	public void setDao(CartDao dao) {
		this.dao = dao;
	}

	
	public void createCart(Product product, int countProduct, String session) {
		Cart cart = new Cart(product, countProduct, session);
		dao.create(cart);
		
	}

	
	public List<Cart> getAllCarts() {
		
		return dao.getAll();
	}

	
	public Cart findByIdCart(int idCart) {
		
		return dao.findById(idCart);
	}

	
	public void deleteCart(int idCart) {
		
		dao.delete(dao.findById(idCart));
		
	}

	
	public void updateCart(int idCart, Product product, int countProduct) {

		Cart cart = dao.findById(idCart);
		cart.setProduct(product);
		cart.setCountProduct(countProduct);
		
		dao.edit(cart);
	}

	public Cart findBySession(String s) {
		
		return dao.findBySession(s);
	}

	public List<Cart> getCartsSession(String s) {
		
		return dao.getAllSession(s);
	}

	public void confirmCart(int idCart) {
		
		Cart cart = dao.findById(idCart);
		boolean confirm = true;
		cart.setAcknowledge(confirm);
		dao.edit(cart);
	}

	
}
