package ua.com.emily.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.emily.dao.RolesDao;
import ua.com.emily.dao.UsersDao;
import ua.com.emily.domain.Roles;
import ua.com.emily.domain.Users;
import ua.com.emily.service.UsersService;
/**
 * Plain JPA implementation of {@link UsersService}.
 * 
 * @author Tanskiy R.
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;
	
	@Autowired
	private RolesDao dao2;

	
	public void createUsers(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers) {
		Roles roles = dao2.findById(2);
		
		Users user = new Users(nameUsers, emailUsers, telephoneNumberUsers, 
				cityUsers, adressUsers, passwordUsers, roles);
		dao.create(user);
		
	}

	
	public void insertUsers(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String passwordUsers) {
		
		Users user = new Users(nameUsers, emailUsers, telephoneNumberUsers, passwordUsers);
		
		dao.create(user);
		
	}

	
	public List<Users> getAllUsers() {
		
		return dao.getAll();
	}

	
	public Users findByIdUsers(int idUsers) {
		
		return dao.findById(idUsers);
	}

	
	public void deleteUsers(int idUsers) {
		
		dao.delete(dao.findById(idUsers));
		
	}

	
	public void updateUsers(int idUsers, String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers, Roles roles) {
		
		Users user = dao.findById(idUsers);
		user.setNameUsers(nameUsers);
		user.setEmailUsers(emailUsers);
		user.setTelephoneNumberUsers(telephoneNumberUsers);
		user.setCityUsers(cityUsers);
		user.setAdressUsers(adressUsers);
		user.setPasswordUsers(passwordUsers);
		user.setRoles(roles);
		
		dao.edit(user);
		
	}

	
	public void updateUsers(int idUsers, String nameUsers, String emailUsers,
			String telephoneNumberUsers, String passwordUsers) {
		Users user = dao.findById(idUsers);
		
		user.setNameUsers(nameUsers);
		user.setEmailUsers(emailUsers);
		user.setEmailUsers(emailUsers);
		user.setTelephoneNumberUsers(telephoneNumberUsers);
		user.setPasswordUsers(passwordUsers);
		
		dao.edit(user);
		
		
	}


	public Users findByEmail(String email) {
		
		return dao.findByEmail(email);
	}


	public void createUsersById(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers, Roles roles) {

		Users user = new Users(nameUsers, emailUsers, telephoneNumberUsers, 
				cityUsers, adressUsers, passwordUsers, roles);
		dao.create(user);
		
	}

}
