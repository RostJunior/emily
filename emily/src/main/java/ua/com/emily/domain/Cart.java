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
 * This class is for storing actual customer orders (cart orders)
 * 
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 */

@Entity
@NamedQueries({
@NamedQuery(name = "Cart.getId", query = "select i from Cart i where i.idCart = :idCart"),
@NamedQuery(name = "Cart.getSession", query = "select i from Cart i where i.session = :session"),

})
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCart;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Product product;

	@Column
	private int countProduct;

	@Column
	private int totalPrice;
	
	@Column
	private String session;
	
	@Column
	private Boolean acknowledge;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "cart")
	private List<Purchase> purchaseList;
	


	/* Constructors: */

	public Cart() {

	}

	public Cart(Product product, int countProduct) {

		this.product = product;
		this.countProduct = countProduct;
		totalPrice = countProduct * product.getPriceProduct();
		acknowledge = false;
	}
	
	

	public Cart(Product product, int countProduct, String session) {
		
		this.product = product;
		this.countProduct = countProduct;
		this.session = session;
		totalPrice = countProduct * product.getPriceProduct();
		acknowledge = false;
	}

	/* Getters and Setters: */

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
	
	public boolean getAcknowledge() {
		return acknowledge;
	}

	public void setAcknowledge(boolean acknowledge) {
		this.acknowledge = acknowledge;
	}
	

	/* ToString method to display the formed user of the order when sending a letter to the user : */

		

	@Override
	public String toString() {
		return idCart + ", " + product.getType().getNameType() + " " + product.getNameProduct() + ", цена " + product.getPriceProduct() + ", в количетве " + countProduct + ";\n";
	}

}
