package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_payment", catalog = "medc_accounts")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentid")
	private int id;

	private String paymentno;

	private Integer personid;
	private Integer persontype;
	private String jrnlname;
	
	private String invoiceno;
	private Double invoicetype;
	private Double invoiceamt;
	private Double invoicebalamt;
	private Double debitaccount;
	private Double creditaccount;
	private Double debitamount;
	private Double creditamount;

	private Double locrefid;
	private Double locname;
	
	private Boolean  bulkflag;
	

	private String draccname;
	private String craccname;
	
	private  Boolean   delflag = false  ;
	
	private String clientcdate;
	private String clientcdate1;
	
	private  String   paymenttype;  
	private  String   ptrefno ;  
	private  Integer   calcflag  ;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	public String getDraccname() {
		return draccname;
	}
	public void setDraccname(String draccname) {
		this.draccname = draccname;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentno() {
		return paymentno;
	}
	public void setPaymentno(String paymentno) {
		this.paymentno = paymentno;
	}
	
	
	

	
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public Double getInvoiceamt() {
		return invoiceamt;
	}
	public void setInvoiceamt(Double invoiceamt) {
		this.invoiceamt = invoiceamt;
	}
	public Double getInvoicebalamt() {
		return invoicebalamt;
	}
	public void setInvoicebalamt(Double invoicebalamt) {
		this.invoicebalamt = invoicebalamt;
	}
	public Double getDebitaccount() {
		return debitaccount;
	}
	public void setDebitaccount(Double debitaccount) {
		this.debitaccount = debitaccount;
	}
	public Double getCreditaccount() {
		return creditaccount;
	}
	public void setCreditaccount(Double creditaccount) {
		this.creditaccount = creditaccount;
	}
	public Double getDebitamount() {
		return debitamount;
	}
	public void setDebitamount(Double debitamount) {
		this.debitamount = debitamount;
	}
	public Double getCreditamount() {
		return creditamount;
	}
	public void setCreditamount(Double creditamount) {
		this.creditamount = creditamount;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Boolean getBulkflag() {
		return bulkflag;
	}
	public void setBulkflag(Boolean bulkflag) {
		this.bulkflag = bulkflag;
	}

	public String getCraccname() {
		return craccname;
	}
	public void setCraccname(String craccname) {
		this.craccname = craccname;
	}
	public Boolean getDelflag() {
		return delflag;
	}
	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}
	public Integer getPersonid() {
		return personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}
	public Integer getPersontype() {
		return persontype;
	}
	public void setPersontype(Integer persontype) {
		this.persontype = persontype;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public String getJrnlname() {
		return jrnlname;
	}
	public void setJrnlname(String jrnlname) {
		this.jrnlname = jrnlname;
	}
	public Double getInvoicetype() {
		return invoicetype;
	}
	public void setInvoicetype(Double invoicetype) {
		this.invoicetype = invoicetype;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getPtrefno() {
		return ptrefno;
	}
	public void setPtrefno(String ptrefno) {
		this.ptrefno = ptrefno;
	}
	public String getClientcdate1() {
		return clientcdate1;
	}
	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}
	public Integer getCountryrefid() {
		return countryrefid;
	}
	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
