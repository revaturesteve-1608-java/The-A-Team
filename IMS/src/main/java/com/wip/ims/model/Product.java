package com.wip.ims.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@Column(name="P_ID")
	@SequenceGenerator(name="PRODUCT_SEQ", sequenceName="PRODUCT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_SEQ")
	private int pId;

	@Column(name="P_NAME")
	private String name;
	
	@Column(name="P_UNIT_PRICE")
	private double unitPrice;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PROD_CAT_JT",
	joinColumns=@JoinColumn(name="P_ID"))//,
//	inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private List<Categories> category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pId, String name, double unitPrice) {
		super();
		this.pId = pId;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Product(int pId, String name, double unitPrice, List<Categories> category) {
		super();
		this.pId = pId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.category = category;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<Categories> getCategory() {
		return category;
	}

	public void setCategory(List<Categories> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", name=" + name + ", unitPrice=" + unitPrice + ", category=" + category + "]";
	}

	
}
