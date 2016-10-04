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
@Table(name="CATEGORIES")
public class Categories {

	@Id
	@Column(name="C_ID")
	@SequenceGenerator(name="CATEGORIES_SEQ", sequenceName="CATEGORIES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIES_SEQ")
	private int cId;
	
	@Column(name="C_NAME")
	private String cName;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PROD_CAT_JT",
	joinColumns=@JoinColumn(name="P_ID"))//,
	private List<Product> product;

	public Categories() {
		super();
	}

	public Categories(int cId, String cName, List<Product> product) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.product = product;
	}

	public Categories(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Categories [cId=" + cId + ", cName=" + cName + ", product=" + product + "]";
	}

}
