package ua.com.emily.domain;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *This class is used for the storage users in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 * 
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Users.getId", query = "select a from Users a where a.idUsers =:idUsers"),
		@NamedQuery(name = "Users.getEmail", query = "select a from Users a where a.emailUsers =:emailUsers"),
		@NamedQuery(name = "Users.telephoneNumber", query = "select a from Users a where a.telephoneNumberUsers =:telephoneNumberUsers") })
public class Users {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsers;

	@Column
	private String nameUsers;

	@Column
	private String emailUsers;
	
	@Column
	@Temporal (value = TemporalType.DATE)
	private Date dateRegistrarion;

	@Column
	private String telephoneNumberUsers;

	@Column
	private String cityUsers;

	@Column
	private String adressUsers;

	@Column
	private String passwordUsers;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Roles roles;
	
	
	
	@OneToMany (cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Purchase> purchaseList;

	/* Constructors: */

	public Users() {

	}

	public Users(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String cityUsers, String adressUsers,
			String passwordUsers, Roles roles) {

		this.nameUsers = nameUsers;
		this.emailUsers = emailUsers;
		this.telephoneNumberUsers = telephoneNumberUsers;
		this.cityUsers = cityUsers;
		this.adressUsers = adressUsers;
		this.passwordUsers = passwordUsers;
		this.roles = roles;
		this.dateRegistrarion = new Date();
	}

	public Users(String nameUsers, String emailUsers,
			String telephoneNumberUsers, String passwordUsers) {

		this.nameUsers = nameUsers;
		this.emailUsers = emailUsers;
		this.telephoneNumberUsers = telephoneNumberUsers;
		this.passwordUsers = passwordUsers;
		this.dateRegistrarion = new Date();

	}

	/* Getters and Setters: */

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	
	
	public Date getDateRegistrarion() {
		return dateRegistrarion;
	}

	public void setDateRegistrarion(Date dateRegistrarion) {
		this.dateRegistrarion = dateRegistrarion;
	}

	public String getNameUsers() {
		return nameUsers;
	}

	public void setNameUsers(String nameUsers) {
		this.nameUsers = nameUsers;
	}

	public String getEmailUsers() {
		return emailUsers;
	}

	public void setEmailUsers(String emailUsers) {
		this.emailUsers = emailUsers;
	}

	public String getTelephoneNumberUsers() {
		return telephoneNumberUsers;
	}

	public void setTelephoneNumberUsers(String telephoneNumberUsers) {
		this.telephoneNumberUsers = telephoneNumberUsers;
	}

	public String getCityUsers() {
		return cityUsers;
	}

	public void setCityUsers(String cityUsers) {
		this.cityUsers = cityUsers;
	}

	public String getAdressUsers() {
		return adressUsers;
	}

	public void setAdressUsers(String adressUsers) {
		this.adressUsers = adressUsers;
	}

	public String getPasswordUsers() {
		return passwordUsers;
	}

	public void setPasswordUsers(String passwordUsers) {
		this.passwordUsers = passwordUsers;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	/* method toString: */

	@Override
	public String toString() {
		return "Users idUsers=" + idUsers + ", nameUsers=" + nameUsers
				+ ", emailUsers=" + emailUsers + ", telephoneNumberUsers="
				+ telephoneNumberUsers + ", cityUsers=" + cityUsers
				+ ", adressUsers=" + adressUsers + ", passwordUsers="
				+ passwordUsers + ", roles=" + roles + ";";
	}

}
