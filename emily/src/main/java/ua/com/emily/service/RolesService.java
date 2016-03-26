package ua.com.emily.service;

import java.util.List;
import ua.com.emily.domain.Roles;
/**
 * Service interface for {@link Roles}s.
 * 
 * @author Tanskiy R.
 */
public interface RolesService {
	/**
	 * Saves the given {@link Roles}.
	 * 
	 * @param roles
	 *
	 */
    void createRoles(String roles);
    /**
	 * Returns all {@link Roles}s.
	 * 
	 * @return
	 */
	List<Roles> getAllRoles();
	/**
	 * Returns {@link Roles} of the given idRoles.
	 * 
	 * @param idRoles
	 * @return
	 */
	Roles findByIdRoles(int idRoles);
	/**
	 * Delete {@link Roles}s of the given idRoles.
	 * 
	 * @param idRoles
	 * 
	 */
	void deleteRoles(int idRoles);
	/**
	 * Update {@link Roles}s of the given idRoles.
	 * 
	 * @param idRoles, roles
	 * 
	 */
		void updateRoles(int idRoles, String roles);
}
