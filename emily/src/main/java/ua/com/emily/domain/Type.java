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
/*
 * the Class Type for the product
 * 
 * */
import javax.persistence.OneToMany;
/**
 * This class is for storage of types of goods in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 * 
 */


@Entity
@NamedQueries({
		@NamedQuery(name = "Type.getId", query = "select a from Type a where a.idType =:idType"),
		@NamedQuery(name = "Type.getType", query = "select a from Type a where a.nameType =:nameType") })
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idType;

	@Column
	private String nameType;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "type")
	private List<Product> productsList;

	/* Constructors: */
	
	public Type() {

	}

	public Type(String nameType) {

		this.nameType = nameType;
	}

	/* Getters and Setters: */
	
	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	/* method toString: */
	
	@Override
	public String toString() {
		return "Type  idType=" + idType + ", nameType=" + nameType + ";";
	}

}
