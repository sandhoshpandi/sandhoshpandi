package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Mahalakshmi
@Entity
@Table(name = "medc_purchaseacknowledge", catalog = "medc_purchase")
public class PurchaseAcknowledge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "puackno")
	private Integer id;
	private Integer roleid;
	private String rolename;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer suserid;
	private Integer acsuserid;
	private Integer empid;
	private String empname;
	private Integer ackstatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Integer getCompanyrefid() {
		return companyrefid;
	}
	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}
	public Integer getBranchrefid() {
		return branchrefid;
	}
	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
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
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getAckstatus() {
		return ackstatus;
	}
	public void setAckstatus(Integer ackstatus) {
		this.ackstatus = ackstatus;
	}
	public Integer getAcsuserid() {
		return acsuserid;
	}
	public void setAcsuserid(Integer acsuserid) {
		this.acsuserid = acsuserid;
	}
	public Integer getSuserid() {
		return suserid;
	}
	public void setSuserid(Integer suserid) {
		this.suserid = suserid;
	}

	
}
