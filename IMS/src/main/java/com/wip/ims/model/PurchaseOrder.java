package com.wip.ims.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE_ORDER")
public class PurchaseOrder {
	
	@Id
	@Column(name="PO_ID")
	@SequenceGenerator(name="PURCHASE_ORDER_SEQ", sequenceName="PURCHASE_ORDER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PURCHASE_ORDER_SEQ")
	private int poId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="S_ID")
//	private int sId;
	private Supplier supplier;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="R_ID")
//	private int rId;
	private Retailer retailer;
	
	@Column(name="PO_TIMESTAMP")
	private Timestamp poTimestamp;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ST_ID")
	private Status status;
	
	
	@OneToMany(mappedBy="poId", fetch=FetchType.EAGER)
	private List<PoLine> poLines;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(int poId, Supplier supplier, Retailer retailer, Timestamp poTimestamp, Status status,
			List<PoLine> poLines) {
		super();
		this.poId = poId;
		this.supplier = supplier;
		this.retailer = retailer;
		this.poTimestamp = poTimestamp;
		this.status = status;
		this.poLines = poLines;
	}

	public PurchaseOrder(int poId, Supplier supplier, Retailer retailer, Timestamp poTimestamp, Status status) {
		super();
		this.poId = poId;
		this.supplier = supplier;
		this.retailer = retailer;
		this.poTimestamp = poTimestamp;
		this.status = status;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public Timestamp getPoTimestamp() {
		return poTimestamp;
	}

	public void setPoTimestamp(Timestamp poTimestamp) {
		this.poTimestamp = poTimestamp;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<PoLine> getPoLines() {
		return poLines;
	}

	public void setPoLines(List<PoLine> poLines) {
		this.poLines = poLines;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", supplier=" + supplier + ", retailer=" + retailer + ", poTimestamp="
				+ poTimestamp + ", status=" + status + ", poLines=" + poLines + "]";
	}

	
}