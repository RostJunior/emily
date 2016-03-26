package ua.com.emily.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * This class is for storage of user roles in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 * 
 */

@Entity
@NamedQueries({
@NamedQuery(name = "Roles.getId", query = "select a from Roles a where a.idRoles =:idRoles"),
@NamedQuery(name = "Roles.getRoles", query = "select a from Roles a where a.roles =:roles")
})
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRoles;
	
	@Column
	private String roles;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "roles")
	private List<Users> roleUsersList;
	
/* Constructors: */	
	
	public Roles(){
		
	}
	
	public Roles(String roles){
		this.roles = roles;
	}
	
/* Getters and Setters:*/	

	public int getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<Users> getRoleUsersList() {
		return roleUsersList;
	}

	public void setRoleUsersList(List<Users> roleUsersList) {
		this.roleUsersList = roleUsersList;
	}

	/* method toString: */
	
	@Override
	public String toString() {
		return "Roles idRoles=" + idRoles + ", roles=" + roles + ";";
	}
	
	

}
