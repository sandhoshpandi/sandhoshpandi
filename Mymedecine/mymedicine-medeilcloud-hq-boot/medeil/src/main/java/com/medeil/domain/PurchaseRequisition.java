package com.medeil.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;



//Mahalakshmi//
@Entity
@Table(name = "medc_purchaserequisition", catalog = "medc_purchase")

public class PurchaseRequisition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purcreqno")
	private Integer id;
	private String purchasereqid;
	private Integer acknowledgedbyuserid;
	private Integer roleid;
    private String rolename;
	private String acknowledgedby;
	private Integer acknowledgedbyid;
	private String acknowledgeddate;
	private String requestedby;
	private Integer requestedbyuserid;
	private String requesteddate;
	private Integer requestedareaid;
	private String requestedarea;
	private Integer approvedbyid;
	private String approvedby;
	private String approveddate;
//	private Integer rejectedbyid;

	private String modifyby;
	private Integer modifybyid;
	private String modifyreason;
	private String modifydate;
	private String createdby;
	private String createddate;
	private Integer companyrefid;
	private Integer branchid;
	private Integer locname;
	private Integer locrefid;
	private String productname;
	private String productid;
	private Integer vendorid;
	private String vendorcode;
	private String vendorname;
	private String uom;
	private String quantity;
	private Integer consumptionqty;
	private String balance;
	private String exptdeliverydate;
	private String quantitytype;
	private String deliverytype;
	private String orderType;
	private Integer rejectid;
	private String RejectionReason;
	private String rejecteddate;
	private String totalproduct;
	private String totalquantity;
	private String totalboxquantity;
	private String totalstripquantity;
	private String totaltabletquantity;
	private String remarks;
	private Integer status;
	private String genericcode;
	private String drugcombination;
	private String oldestimationvalue;
	private String abcanalysis;
	private String manufacturedid;
	private Integer taxstatus;
	private Integer suserid;
	

	
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "PurchaseRequisition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	

	public String getManufacturedid() {
		return manufacturedid;
	}

	public void setManufacturedid(String manufacturedid) {
		this.manufacturedid = manufacturedid;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcknowledgedbyuserid() {
		return acknowledgedbyuserid;
	}

	public void setAcknowledgedbyuserid(Integer acknowledgedbyuserid) {
		this.acknowledgedbyuserid = acknowledgedbyuserid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getPurchasereqid() {
		return purchasereqid;
	}

	public void setPurchasereqid(String purchasereqid) {
		this.purchasereqid = purchasereqid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getAcknowledgedby() {
		return acknowledgedby;
	}

	public void setAcknowledgedby(String acknowledgedby) {
		this.acknowledgedby = acknowledgedby;
	}

	public String getAcknowledgeddate() {
		return acknowledgeddate;
	}

	public void setAcknowledgeddate(String acknowledgeddate) {
		this.acknowledgeddate = acknowledgeddate;
	}

	public String getRequestedby() {
		return requestedby;
	}

	public void setRequestedby(String requestedby) {
		this.requestedby = requestedby;
	}

	public String getRequesteddate() {
		return requesteddate;
	}

	public void setRequesteddate(String requesteddate) {
		this.requesteddate = requesteddate;
	}

	public String getRequestedarea() {
		return requestedarea;
	}

	public void setRequestedarea(String requestedarea) {
		this.requestedarea = requestedarea;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public String getApproveddate() {
		return approveddate;
	}

	public void setApproveddate(String approveddate) {
		this.approveddate = approveddate;
	}

	public String getModifyby() {
		return modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	public String getModifydate() {
		return modifydate;
	}

	public Integer getTaxstatus() {
		return taxstatus;
	}

	public void setTaxstatus(Integer taxstatus) {
		this.taxstatus = taxstatus;
	}

	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorcode() {
		return vendorcode;
	}

	public void setVendorcode(String vendorcode) {
		this.vendorcode = vendorcode;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
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

	public String getQuantitytype() {
		return quantitytype;
	}

	public void setQuantitytype(String quantitytype) {
		this.quantitytype = quantitytype;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getRejectid() {
		return rejectid;
	}

	public void setRejectid(Integer rejectid) {
		this.rejectid = rejectid;
	}

	public String getRejectionReason() {
		return RejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		RejectionReason = rejectionReason;
	}

	public String getTotalproduct() {
		return totalproduct;
	}

	public void setTotalproduct(String totalproduct) {
		this.totalproduct = totalproduct;
	}

	public String getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(String totalquantity) {
		this.totalquantity = totalquantity;
	}

	public String getTotalboxquantity() {
		return totalboxquantity;
	}

	public void setTotalboxquantity(String totalboxquantity) {
		this.totalboxquantity = totalboxquantity;
	}

	public String getTotalstripquantity() {
		return totalstripquantity;
	}

	public void setTotalstripquantity(String totalstripquantity) {
		this.totalstripquantity = totalstripquantity;
	}

	public String getTotaltabletquantity() {
		return totaltabletquantity;
	}

	public void setTotaltabletquantity(String totaltabletquantity) {
		this.totaltabletquantity = totaltabletquantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGenericcode() {
		return genericcode;
	}

	public void setGenericcode(String genericcode) {
		this.genericcode = genericcode;
	}

	public String getDrugcombination() {
		return drugcombination;
	}

	public void setDrugcombination(String drugcombination) {
		this.drugcombination = drugcombination;
	}

	public String getOldestimationvalue() {
		return oldestimationvalue;
	}

	public void setOldestimationvalue(String oldestimationvalue) {
		this.oldestimationvalue = oldestimationvalue;
	}

	public String getAbcanalysis() {
		return abcanalysis;
	}

	public void setAbcanalysis(String abcanalysis) {
		this.abcanalysis = abcanalysis;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Integer getRequestedbyuserid() {
		return requestedbyuserid;
	}

	public void setRequestedbyuserid(Integer requestedbyuserid) {
		this.requestedbyuserid = requestedbyuserid;
	}

	public Integer getRequestedareaid() {
		return requestedareaid;
	}

	public void setRequestedareaid(Integer requestedareaid) {
		this.requestedareaid = requestedareaid;
	}

	public Integer getAcknowledgedbyid() {
		return acknowledgedbyid;
	}

	public void setAcknowledgedbyid(Integer acknowledgedbyid) {
		this.acknowledgedbyid = acknowledgedbyid;
	}

	public Integer getApprovedbyid() {
		return approvedbyid;
	}



	public String getRejecteddate() {
		return rejecteddate;
	}

	public void setApprovedbyid(Integer approvedbyid) {
		this.approvedbyid = approvedbyid;
	}



	public void setRejecteddate(String rejecteddate) {
		this.rejecteddate = rejecteddate;
	}

	public Integer getModifybyid() {
		return modifybyid;
	}

	public String getModifyreason() {
		return modifyreason;
	}

	public void setModifybyid(Integer modifybyid) {
		this.modifybyid = modifybyid;
	}

	public void setModifyreason(String modifyreason) {
		this.modifyreason = modifyreason;
	}

	public Integer getSuserid() {
		return suserid;
	}

	public void setSuserid(Integer suserid) {
		this.suserid = suserid;
	}

}
