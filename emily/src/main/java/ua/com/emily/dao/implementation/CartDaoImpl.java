package ua.com.emily.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;



import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.CartDao;
import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Product;

/**
 * Repository to manage {@link Cart} instances.
 * 
 * @author Tanskiy R.
 */
@Repository
public class CartDaoImpl extends GeneralDaoImpl<Cart, Integer>
implements CartDao{

	public CartDaoImpl() {
		super(Cart.class);
		
	}
	
	@Transactional
	public Cart findById(int id){
		return (Cart) em.createNamedQuery("Cart.getId").setParameter("idCart", id).getSingleResult();
	}
	@Transactional
	public Cart findBySession(String s) {
		
		return (Cart) em.createNamedQuery("Cart.getSession").setParameter("session", s).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> getAllSession(String s) {
		
		return (List<Cart>) em.createNamedQuery("Cart.getSession").setParameter("session", s).getResultList();
	}
	@Transactional
	public Cart findByProduct(Product product) {
		
		return (Cart) em.createNamedQuery("Cart.getProduct").setParameter("product", product);
	}
	
	
	

}
