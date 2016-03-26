package ua.com.emily.dao;

import ua.com.emily.domain.Type;

/**
 *Dao interface for find object Type in the database by ID
 * 
 */

public interface TypeDao extends GeneralDao<Type, Integer>{

	Type findById(int id);
}
