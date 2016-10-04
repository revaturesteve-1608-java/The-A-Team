package com.wip.ims.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "SALES")
public class Sales {

	// saId
	@Id
	@Column(name = "SA_ID")
	@SequenceGenerator(name = "SALES_SEQ", sequenceName = "SALES_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALES_SEQ")
	private int saId;

	// rId
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "R_ID")
	private Retailer retailer;

	// pId
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "P_ID")
	private Product product;

	// saQty
	@Column(name = "SA_QNTY")
	private int saQty;

	// saPrice
	@Column(name = "SA_PRICE")
	private double saPrice;

	// saTimestamp
	@Column(name = "SA_TIMESTAMP")
	private Timestamp saTimestamp;

	public Sales() {
	}

	public Sales(int saId, Retailer retailer, Product product, int saQty, double saPrice, Timestamp saTimestamp) {
		super();
		this.saId = saId;
		this.retailer = retailer;
		this.product = product;
		this.saQty = saQty;
		this.saPrice = saPrice;
		this.saTimestamp = saTimestamp;
	}

	public int getSaId() {
		return saId;
	}

	public void setSaId(int saId) {
		this.saId = saId;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSaQty() {
		return saQty;
	}

	public void setSaQty(int saQty) {
		this.saQty = saQty;
	}

	public double getSaPrice() {
		return saPrice;
	}

	public void setSaPrice(double saPrice) {
		this.saPrice = saPrice;
	}

	public Timestamp getSaTimestamp() {
		return saTimestamp;
	}

	public void setSaTimestamp(Timestamp saTimestamp) {
		this.saTimestamp = saTimestamp;
	}

	@Override
	public String toString() {
		return "Sales [saId=" + saId + ", retailer=" + retailer + ", product=" + product + ", saQty=" + saQty
				+ ", saPrice=" + saPrice + ", saTimestamp=" + saTimestamp + "]";
	}

}
