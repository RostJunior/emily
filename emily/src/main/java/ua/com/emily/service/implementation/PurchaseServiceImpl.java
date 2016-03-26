package ua.com.emily.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.emily.dao.PurchaseDao;
import ua.com.emily.domain.Cart;
import ua.com.emily.domain.Purchase;
import ua.com.emily.domain.Transporter;
import ua.com.emily.domain.Users;
import ua.com.emily.service.PurchaseService;
/**
 * Plain JPA implementation of {@link PurchaseService}.
 * 
 * @author Tanskiy R.
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseDao dao;

	
	public void createPurchase(Users client, Transporter dostavka, Cart cart) {
		Purchase purchase = new Purchase(client, dostavka, cart);
		
		dao.create(purchase);
		
	}

	
	public List<Purchase> getAllPurchases() {
		
		return dao.getAll();
	}

	
	public Purchase findByIdPurchase(int idPurchase) {
 
		return dao.findById(idPurchase);
	}

	
	public void deletePurchase(int idPurchase) {
		dao.delete(dao.findById(idPurchase));
		
	}

	
	public void updatePurchase(int idPurchase, Users client,
			Transporter dostavka, Cart cart) {
		
		Purchase purchase = dao.findById(idPurchase);
		purchase.setClient(client);
		purchase.setDostavka(dostavka);
		purchase.setCart(cart);
				
		dao.edit(purchase);
		
	}
	
}
