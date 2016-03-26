package ua.com.emily.dao;

import ua.com.emily.domain.Purchase;
/**
 *Dao interface for find object Purchase in the database by ID
 * 
 */
public interface PurchaseDao extends GeneralDao<Purchase, Integer>{

	Purchase findById(int id);
}
