package ua.com.emily.dao;

import ua.com.emily.domain.Roles;

/**
 *Dao interface for find object Roles in the database by ID
 * 
 */

public interface RolesDao extends GeneralDao<Roles, Integer>{

	Roles findById(int id);
}
