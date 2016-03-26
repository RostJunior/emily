package ua.com.emily.dao;


import ua.com.emily.domain.Product;

/**
 *Dao interface for find object Product in the database by ID
 * 
 */

public interface ProductDao extends GeneralDao<Product, Integer> {
	
	Product findById(int id);

}
