package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 /** @author Mahalakshmi
 *
 */
@Entity
@Table(name = "medc_grn", catalog = "medc_purchase")
public class Grn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grnid")
	private Integer id;
	private String vendorinvno;
	private String vendorcode;
	private String vendorname;
	private String vendorcontactno;
	private String grnno;
	private String pono;
	private String crrency;
	private String exchangedate;
	private String receiveddate;
	private String duedate;
	private String deliveredto;
	private String preparedby;
	private String acknowledgedby;
	private String totalamt;
	private Integer locrefid;
	private Integer locname;
	private Integer branchrefid;
	private Integer companyrefid;
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	public void setLocname(Integer locname) {
		this.locname = locname;
	}
	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}
	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}
	public String getVendorinvno() {
		return vendorinvno;
	}
	public void setVendorinvno(String vendorinvno) {
		this.vendorinvno = vendorinvno;
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
	public String getVendorcontactno() {
		return vendorcontactno;
	}
	public void setVendorcontactno(String vendorcontactno) {
		this.vendorcontactno = vendorcontactno;
	}
	
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getCrrency() {
		return crrency;
	}
	public void setCrrency(String crrency) {
		this.crrency = crrency;
	}
	public String getExchangedate() {
		return exchangedate;
	}
	public void setExchangedate(String exchangedate) {
		this.exchangedate = exchangedate;
	}
	public String getReceiveddate() {
		return receiveddate;
	}
	public void setReceiveddate(String receiveddate) {
		this.receiveddate = receiveddate;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getDeliveredto() {
		return deliveredto;
	}
	public void setDeliveredto(String deliveredto) {
		this.deliveredto = deliveredto;
	}
	public String getPreparedby() {
		return preparedby;
	}
	public void setPreparedby(String preparedby) {
		this.preparedby = preparedby;
	}
	public String getAcknowledgedby() {
		return acknowledgedby;
	}
	public void setAcknowledgedby(String acknowledgedby) {
		this.acknowledgedby = acknowledgedby;
	}
	public String getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(String totalamt) {
		this.totalamt = totalamt;
	}
	public int getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}
	public int getLocname() {
		return locname;
	}
	public void setLocname(int locname) {
		this.locname = locname;
	}
	public int getBranchrefid() {
		return branchrefid;
	}
	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}
	public int getCompanyrefid() {
		return companyrefid;
	}
	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGrnno() {
		return grnno;
	}
	public void setGrnno(String grnno) {
		this.grnno = grnno;
	}
	
}