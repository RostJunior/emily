package ua.com.emily.dao.implementation;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.UsersDao;
import ua.com.emily.domain.Users;

/**
 * The practical implementation of operations UsersDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class UsersDaoImpl extends GeneralDaoImpl<Users, Integer> implements UsersDao{

	public UsersDaoImpl(){
		super(Users.class);
	}

	@Transactional
	public Users findById(int id) {
		
		return (Users) em.createNamedQuery("Users.getId").setParameter("idUsers", id).getSingleResult();
	}
	@Transactional
	public Users findByEmail(String email) {
		Users users = null;
		try {
			users = (Users) em.createNamedQuery("Users.getEmail").setParameter("emailUsers", email).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			
			System.out.println("No user found!");
		}
		return users;
	}
}
