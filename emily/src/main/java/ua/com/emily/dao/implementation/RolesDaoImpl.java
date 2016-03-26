package ua.com.emily.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.emily.dao.RolesDao;
import ua.com.emily.domain.Roles;

/**
 * The practical implementation of operations RolesDao
 * 
 * @author Tanskiy R.
 */


@Repository
public class RolesDaoImpl  extends GeneralDaoImpl<Roles, Integer> implements RolesDao{

	public RolesDaoImpl(){
		super(Roles.class);
	}

	@Transactional
	public Roles findById(int id) {
		
		return (Roles) em.createNamedQuery("Roles.getId").setParameter("idRoles", id).setMaxResults(1).getSingleResult();
	}
}
