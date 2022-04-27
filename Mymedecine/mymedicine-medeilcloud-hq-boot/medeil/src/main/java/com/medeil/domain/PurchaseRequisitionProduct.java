package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_purchaserequisitionproduct", catalog = "medc_purchase")
public class PurchaseRequisitionProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purcreqprodid")
	private Integer id;

	private String productname;
	private String productid;
	private String uom;
	private String quantity;
	private Integer consumptionqty;
	private String balance;
	private String exptdeliverydate;
	private String remarks;
	private Integer companyrefid;
	private Integer branchid;
	private Integer locname;
	private Integer locrefid;
	private Integer purcreqnoref;
	private Integer createdid;
	private String createddate;
	private Integer modifyid;
	private String modifieddate;
	private String modifyreason;
	private Integer suserid;
	private Integer status;
	private Integer reqstatus;
	
	public Integer getReqstatus() {
		return reqstatus;
	}

	public void setReqstatus(Integer reqstatus) {
		this.reqstatus = reqstatus;
	}

	//maha
	private String purchasereqid;

	public String getPurchasereqid() {
		return purchasereqid;
	}

	public void setPurchasereqid(String purchasereqid) {
		this.purchasereqid = purchasereqid;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getPurcreqnoref() {
		return purcreqnoref;
	}

	public void setPurcreqnoref(Integer purcreqnoref) {
		this.purcreqnoref = purcreqnoref;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getConsumptionqty() {
		return consumptionqty;
	}

	public void setConsumptionqty(Integer consumptionqty) {
		this.consumptionqty = consumptionqty;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getExptdeliverydate() {
		return exptdeliverydate;
	}

	public void setExptdeliverydate(String exptdeliverydate) {
		this.exptdeliverydate = exptdeliverydate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public String getCreateddate() {
		return createddate;
	}

	public Integer getModifyid() {
		return modifyid;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public String getModifyreason() {
		return modifyreason;
	}

	public Integer getSuserid() {
		return suserid;
	}

	

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public void setModifyid(Integer modifyid) {
		this.modifyid = modifyid;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setModifyreason(String modifyreason) {
		this.modifyreason = modifyreason;
	}

	public void setSuserid(Integer suserid) {
		this.suserid = suserid;
	}

	public Integer getCreatedid() {
		return createdid;
	}

	public void setCreatedid(Integer createdid) {
		this.createdid = createdid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
