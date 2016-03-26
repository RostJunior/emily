package ua.com.emily.dao;

import ua.com.emily.domain.Transporter;

/**
 *Dao interface for find object Transporter in the database by ID
 * 
 */

public interface TransporterDao extends GeneralDao<Transporter, Integer>{

	Transporter findById(int id);
}
