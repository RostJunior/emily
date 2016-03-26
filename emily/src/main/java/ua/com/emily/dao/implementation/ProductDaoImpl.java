package ua.com.emily.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.ProductDao;
import ua.com.emily.domain.Product;

/**
 * The practical implementation of operations ProductDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class ProductDaoImpl extends GeneralDaoImpl<Product, Integer> implements ProductDao{

	public ProductDaoImpl(){
		super(Product.class);
	}

	@Transactional
	public Product findById(int id) {
		
		return (Product) em.createNamedQuery("Product.getId").setParameter("idProduct", id).getSingleResult();
	}
	
	
}
