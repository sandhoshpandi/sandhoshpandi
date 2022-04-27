package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_journal", catalog = "medc_accounts")
public class Journal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "journalid")
	private int id;

	private String journalno;

	private Integer personid;
	private Integer persontype;
	private Integer jrnltype;

	private String jrnlname;

	private Integer invoiceno;
	private Double invoicetype;
	private Double invoiceamt;
	private Double invoicebalamt;
	private Double debitaccount;
	private Double creditaccount;
	private Double debitamount;
	private Double creditamount;

	private Double locrefid;
	private Double locname;

	private Boolean bulkflag;

	private String draccname;
	private String craccname;

	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;

	private String paymenttype;
	private String ptrefno;
	private Integer calcflag;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	private String invoicename;

	private String personame;
	private String bankname;

	private String remarks;
	
	
	private Integer formid;
	private String date;
	private String ExpiryDate;
	private String clientmdate;
	

	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private Integer debitcalcflag = 0;
	private Integer creditcalcflag = 0;
	private Boolean adjbalflag = false;

	public String getPersoname() {
		return personame;
	}

	public void setPersoname(String personame) {
		this.personame = personame;
	}

	public Integer getInvoiceno() {
		return invoiceno;
	}
	
	
	
	
	
	
	
	

	public void setInvoiceno(Integer invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getJournalno() {
		return journalno;
	}

	public void setJournalno(String journalno) {
		this.journalno = journalno;
	}

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

	public Integer getJrnltype() {
		return jrnltype;
	}

	public void setJrnltype(Integer jrnltype) {
		this.jrnltype = jrnltype;
	}

	public String getInvoicename() {
		return invoicename;
	}

	public void setInvoicename(String invoicename) {
		this.invoicename = invoicename;
	}

	public Integer getDebitcalcflag() {
		return debitcalcflag;
	}

	public void setDebitcalcflag(Integer debitcalcflag) {
		this.debitcalcflag = debitcalcflag;
	}

	public Integer getCreditcalcflag() {
		return creditcalcflag;
	}

	public void setCreditcalcflag(Integer creditcalcflag) {
		this.creditcalcflag = creditcalcflag;
	}

	public Boolean getAdjbalflag() {
		return adjbalflag;
	}

	public void setAdjbalflag(Boolean adjbalflag) {
		this.adjbalflag = adjbalflag;
	}

	public Integer getFormid() {
		return formid;
	}

	public void setFormid(Integer formid) {
		this.formid = formid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public String getClientmdate() {
		return clientmdate;
	}

	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


}
