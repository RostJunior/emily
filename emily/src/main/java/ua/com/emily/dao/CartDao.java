package ua.com.emily.dao;

import java.util.List;

import ua.com.emily.domain.Cart;

/**
 * Dao interface for find object Cart in the database by ID, 
 * Session and show a list of all objects in session 
 * 
 * @author Tanskiy R.
 */
public interface CartDao extends GeneralDao<Cart, Integer>{
	
	
	Cart findById(int id);
	
	
	Cart findBySession(String s);
	
	List<Cart> getAllSession(String s);
	
}
