package ua.com.emily.service;

import java.util.List;

import ua.com.emily.domain.Roles;
import ua.com.emily.domain.Users;

public interface UsersService {

	void createUsers(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers);
	
	void createUsersById(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers, Roles roles);

	void insertUsers(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String passwordUsers);

	List<Users> getAllUsers();

	Users findByIdUsers(int idUsers);
	
	Users findByEmail(String email);

	void deleteUsers(int idUsers);

	void updateUsers(int idUsers, String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers, Roles roles);

	void updateUsers(int idUsers, String nameUsers, String emailUsers,
			String telephoneNumberUsers, String passwordUsers);

}
