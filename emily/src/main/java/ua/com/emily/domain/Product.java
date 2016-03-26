package ua.com.emily.domain;

import java.util.List;

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

/**
 * This class is for the storage of goods in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 * 
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Product.getId", query = "select a from Product a where a.idProduct =:idProduct"),
		@NamedQuery(name = "Product.getType", query = "select a from Product a where a.nameProduct =:nameProduct") })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduct;

	@Column
	private String nameProduct;

	@Column
	private String namePhoto;

	@Column
	private String description;

	@Column
	private int priceProduct;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Type type;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "product")
	private List<Cart> cartList;

	/* Constructors: */

	public Product() {

	}

	public Product(String nameProduct, int priceProduct, Type type) {

		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.type = type;
	}

	public Product(String nameProduct, int priceProduct, String namePhoto,
			Type type, String description) {

		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.namePhoto = namePhoto;
		this.type = type;
		this.description = description;
	}
	
	/* Getters and Setters:*/

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}

	public Type getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getNamePhoto() {
		return namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	/* method toString: */
	
	@Override
	public String toString() {
		return "Product =" + idProduct + ", nameProduct=" + nameProduct
				+ ", priceProduct=" + priceProduct + ", type=" + type + ";";
	}

}
