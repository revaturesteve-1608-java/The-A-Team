package com.wip.ims.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PO_LINE")
public class PoLine {
	
	@Id
	@Column(name="POL_ID")
	@SequenceGenerator(name="PO_LINE_SEQ", sequenceName="PO_LINE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PO_LINE_SEQ")
	private int polId;
	
	@Column(name="PO_ID")
	private int poId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="P_ID")
//	private int pId;
	private Product product;
	
	@Column(name="POL_QNTY")
	int polQnty;
	
	@Column(name="POL_PRICE")
	double polPrice;
	
	public PoLine() {
		super();
	}

	public PoLine(int polId, int poId, Product product, int polQnty, double polPrice) {
		super();
		this.polId = polId;
		this.poId = poId;
		this.product = product;
		this.polQnty = polQnty;
		this.polPrice = polPrice;
	}

	public int getPolId() {
		return polId;
	}

	public void setPolId(int polId) {
		this.polId = polId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPolQnty() {
		return polQnty;
	}

	public void setPolQnty(int polQnty) {
		this.polQnty = polQnty;
	}

	public double getPolPrice() {
		return polPrice;
	}

	public void setPolPrice(double polPrice) {
		this.polPrice = polPrice;
	}

	@Override
	public String toString() {
		return "PoLine [polId=" + polId + ", poId=" + poId + ", product=" + product + ", polQnty=" + polQnty
				+ ", polPrice=" + polPrice + "]";
	}

	
}