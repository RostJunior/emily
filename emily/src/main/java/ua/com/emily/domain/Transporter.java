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
 * This class is for the storage of delivery services in the database
 *
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 * 
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Transporter.getId", query = "select a from Transporter a where a.idTransporter =:idTransporter"),
		@NamedQuery(name = "Transporter.getName", query = "select a from Transporter a where a.nameTransporter =:nameTransporter") })
public class Transporter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTransporter;

	@Column
	private String nameTransporter;

	@Column
	private int costOfDelivery;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "dostavka")
	private List<Purchase> dostavkaList;

	/* Constructors: */

	public Transporter() {

	}

	public Transporter(String nameTransporter, int costOfDelivery) {

		this.nameTransporter = nameTransporter;
		this.costOfDelivery = costOfDelivery;
	}

	/* Getters and Setters: */

	public int getIdTransporter() {
		return idTransporter;
	}

	public void setIdTransporter(int idTransporter) {
		this.idTransporter = idTransporter;
	}

	public String getNameTransporter() {
		return nameTransporter;
	}

	public void setNameTransporter(String nameTransporter) {
		this.nameTransporter = nameTransporter;
	}

	public int getCostOfDelivery() {
		return costOfDelivery;
	}

	public void setCostOfDelivery(int costOfDelivery) {
		this.costOfDelivery = costOfDelivery;
	}

	public List<Purchase> getDostavka() {
		return dostavkaList;
	}

	public void setDostavka(List<Purchase> dostavka) {
		this.dostavkaList = dostavka;
	}

	/* method toString: */
	
	@Override
	public String toString() {
		return "Transporter idTransporter=" + idTransporter
				+ ", nameTransporter=" + nameTransporter + ", costOfDelivery="
				+ costOfDelivery +  ";";
	}

}
