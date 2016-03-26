package ua.com.emily.dao;

import ua.com.emily.domain.Users;

/**
 *Dao interface for find Users object in the database by ID and email
 * 
 */
public interface UsersDao extends GeneralDao<Users, Integer>{

	Users findById(int id);
		
	Users findByEmail(String email);
}
