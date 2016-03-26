package ua.com.emily.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.emily.dao.RolesDao;
import ua.com.emily.domain.Roles;
import ua.com.emily.service.RolesService;
/**
 * Plain JPA implementation of {@link RolesService}.
 * 
 * @author Tanskiy R.
 */
@Service("rolesService")
public class RolesServiceImpl implements RolesService{
	
	@Autowired
	private RolesDao dao;

	
	public void createRoles(String roles) {
		Roles role = new Roles(roles);
		dao.create(role);
		
	}

	
	public List<Roles> getAllRoles() {
		
		return dao.getAll();
	}

	
	public Roles findByIdRoles(int idRoles) {
		
		return dao.findById(idRoles);
	}

	
	public void deleteRoles(int idRoles) {

		dao.delete(dao.findById(idRoles));
		
	}

	
	public void updateRoles(int idRoles, String roles) {
		
		Roles role = dao.findById(idRoles);
		role.setRoles(roles);
		
		dao.edit(role);
		
	}

}
