package ua.com.emily.service;

import java.util.List;

import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Purchase;
import ua.com.emily.domain.Transporter;
import ua.com.emily.domain.Users;
/**
 * Service interface for {@link Purchase}s.
 * 
 * @author Tanskiy R.
 */

public interface PurchaseService {
	/**
	 * Saves the given {@link Purchase}.
	 * 
	 * @param client, dostavka, cart
	 *
	 */
	void createPurchase(Users client, Transporter dostavka, Cart cart);
	/**
	 * Returns all {@link Purchase}s.
	 * 
	 * @return
	 */
	List<Purchase> getAllPurchases();
	/**
	 * Returns {@link Purchase} of the given idPurchase.
	 * 
	 * @param idPurchase
	 * @return
	 */
	Purchase findByIdPurchase(int idPurchase);
	/**
	 * Delete {@link Purchase}s of the given idPurchase.
	 * 
	 * @param idPurchase
	 * 
	 */
	void deletePurchase(int idPurchase);

	/**
	 * Update {@link Purchase}s of the given idPurchase.
	 * 
	 * @param idPurchase, client, dostavka, cart
	 * 
	 */
	void updatePurchase(int idPurchase, Users client, Transporter dostavka, Cart cart);
	

}
