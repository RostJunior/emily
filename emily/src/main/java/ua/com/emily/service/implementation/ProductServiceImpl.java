package ua.com.emily.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.emily.dao.ProductDao;
import ua.com.emily.domain.Product;
import ua.com.emily.domain.Type;
import ua.com.emily.service.ProductService;
/**
 * Plain JPA implementation of {@link ProductService}.
 * 
 * @author Tanskiy R.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao dao;

	
	public void createProduct(String nameProduct, int priceProduct, String namePhoto, Type type, String description) {

		Product product = new Product(nameProduct, priceProduct, namePhoto, type, description);
		
		dao.create(product);
		
	}

	
	public List<Product> getAllProducts() {
		
		return dao.getAll();
	}

	
	public Product findById(int idProduct) {
		
		return dao.findById(idProduct);
	}

	
	public void deleteProduct(int idProduct) {
		dao.delete(dao.findById(idProduct));
		
	}

	
	public void updateProduct(int idProduct, String nameProduct, int priceProduct, Type type, 
			String namePhoto, String description) {
		
		Product product = dao.findById(idProduct);
		
		product.setNameProduct(nameProduct);
		product.setPriceProduct(priceProduct);
		product.setType(type);
		product.setDescription(description);
		product.setNamePhoto(namePhoto);
		
		
		dao.edit(product);
	}


	public void updatePhotoProduct(int idProduct, String namePhoto) {
		Product product = dao.findById(idProduct);
		
		product.setNamePhoto(namePhoto);
		
		dao.edit(product);
		
	}


	
}
