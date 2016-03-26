package ua.com.emily.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.PurchaseDao;
import ua.com.emily.domain.Purchase;
/**
 * The practical implementation of operations PurchaseDao
 * 
 * @author Tanskiy R.
 */
@Repository
public class PurchaseDaoImpl extends GeneralDaoImpl<Purchase, Integer> implements PurchaseDao{

	public PurchaseDaoImpl() {
		super(Purchase.class);
		
	}

	@Transactional
	public Purchase findById(int id) {
		
		return (Purchase) em.createNamedQuery("Purchase.getId").setParameter("idPurchase", id).getSingleResult();
	}

}
