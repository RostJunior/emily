package ua.com.emily.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class to store the resulting table in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 */

@Entity
@NamedQuery(name = "Purchase.getId", query = "select i from Purchase i where i.idPurchase = :idPurchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPurchase;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Users client;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Transporter dostavka;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Cart cart;

	@Column
	@Temporal(value = TemporalType.DATE)
	private Date datePurchase;

	@Column
	private int totalAmount;

	/* Constructors: */

	public Purchase() {

	}

	public Purchase(Users client, Transporter dostavka, Cart cart) {

		this.client = client;
		this.dostavka = dostavka;
		this.cart = cart;
		this.datePurchase = new Date();
		this.totalAmount = cart.getTotalPrice() + dostavka.getCostOfDelivery();

	}

	/* Getters and Setters: */

	public int getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(int idPurchase) {
		this.idPurchase = idPurchase;
	}

	public Users getClient() {
		return client;
	}

	public void setClient(Users client) {
		this.client = client;
	}

	public Transporter getDostavka() {
		return dostavka;
	}

	public void setDostavka(Transporter dostavka) {
		this.dostavka = dostavka;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	/* method toString: */

	@Override
	public String toString() {
		return "Purchase =" + idPurchase + ", client=" + client + ", dostavka="
				+ dostavka + ", cart=" + cart + ", datePurchase="
				+ datePurchase + ", totalAmount=" + totalAmount + ";";
	}

}
