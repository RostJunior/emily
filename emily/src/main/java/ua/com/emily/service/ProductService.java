package ua.com.emily.service;

import java.util.List;
import ua.com.emily.domain.Product;
import ua.com.emily.domain.Type;
/**
 * Service interface for {@link Product}s.
 * 
 * @author Tanskiy R.
 */

public interface ProductService {
	
	/**
	 * Saves the given {@link Product}.
	 * 
	 * @param nameProduct, priceProduct, namePhoto, type, description
	 *
	 */

	void createProduct(String nameProduct, int priceProduct, String namePhoto, Type type, String description);
	/**
	 * Returns all {@link Product}s.
	 * 
	 * @return
	 */
	List<Product> getAllProducts();
	
	/**
	 * Returns {@link Product} of the given idProduct.
	 * 
	 * @param idProduct
	 * @return
	 */
	Product findById(int idProduct);
	/**
	 * Delete {@link Product}s of the given idProduct.
	 * 
	 * @param idProduct
	 * 
	 */
	
	void deleteProduct(int idProduct);
	
	/**
	 * Update {@link Product}s of the given idProduct.
	 * 
	 * @param idProduct, nameProduct, priceProduct, type, namePhoto, description
	 * 
	 */
	
	void updateProduct(int idProduct, String nameProduct, int priceProduct, Type type, String namePhoto, String description);
	
	/**
	 * Update {@link Product}s of the given idProduct.
	 * 
	 * @param idProduct, namePhoto
	 * 
	 */
	void updatePhotoProduct(int idProduct, String namePhoto);
	
}
