package ua.com.emily.service;

import java.util.List;

import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Type;
/**
 * Service interface for {@link Type}s.
 * 
 * @author Tanskiy R.
 */
public interface TypeService {
	/**
	 * Saves the given {@link Cart}.
	 * 
	 * @param product, countProduct, session
	 *
	 */
	void createType(String nameType);
	/**
	 * Returns all {@link Type}s.
	 * 
	 * @return
	 */
	List<Type> getAllTypes();
	/**
	 * Returns all {@link Type}s of the given idType.
	 * 
	 * @param Type
	 * @return
	 */
	Type findByIdType(int idType);
	/**
	 * Delete {@link Type}s of the given idType.
	 * 
	 * @param idType
	 * 
	 */
	void deleteType(int idType);
	/**
	 * Update {@link Type}s of the given idType.
	 * 
	 * @param idType, nameType
	 * 
	 */
	void updateType(int idType, String nameType);
	
}
