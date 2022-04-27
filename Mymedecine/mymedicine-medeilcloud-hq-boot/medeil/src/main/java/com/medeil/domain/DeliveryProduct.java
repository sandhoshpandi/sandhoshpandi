package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_dchallanproduct", catalog = "medc_stock")
public class DeliveryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DcProID")
	private int id;
	private int dcrefid;
	private int  drugproductrefid;
	private Double boxqty;
	private Double stripqty;
	private Double tabqty;
	private Double totalqty;
	private int fromlocname;
	private int fromlocrefid;
	private int tolocrefid;
	private int tolocname;
	private int companyrefid;
	private int branchrefid;
	private int locrefid;
	private int locname;
	private String clientcdate;
	private String clientcdate1;
	private Integer calcflag;
	private int billtyperefid;
	private int batchrefid;
	private String expirydate;
	private String batchname;
	private String stripperbox;
	private String quantityperstrip;
	private String packageunit;
	
	@Transient
	private int salesorderrefid;

	private int poid;
	@Transient
	private int stockno;
	
	
	//maha
		private String productcode;
		private String productname;
		private Integer packsize;
		private String uom;
		private Integer batchno;
		private String quantity;
		private Integer unitprice;
		private String Foc;
		private String disper;
	    private String disamt;
		private String amount;
		private String remark;
		private Integer consignment;
	   
		
	
	public Integer getConsignment() {
			return consignment;
		}
		public void setConsignment(Integer consignment) {
			this.consignment = consignment;
		}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getPacksize() {
		return packsize;
	}
	public void setPacksize(Integer packsize) {
		this.packsize = packsize;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public Integer getBatchno() {
		return batchno;
	}
	public void setBatchno(Integer batchno) {
		this.batchno = batchno;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Integer getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}
	public String getFoc() {
		return Foc;
	}
	public void setFoc(String foc) {
		Foc = foc;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public String getDisper() {
		return disper;
	}
	public void setDisper(String disper) {
		this.disper = disper;
	}
	public String getDisamt() {
		return disamt;
	}
	public void setDisamt(String disamt) {
		this.disamt = disamt;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDcrefid() {
		return dcrefid;
	}
	public void setDcrefid(int dcrefid) {
		this.dcrefid = dcrefid;
	}
	public int getDrugproductrefid() {
		return drugproductrefid;
	}
	public void setDrugproductrefid(int drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
	}
	public Double getBoxqty() {
		return boxqty;
	}
	public void setBoxqty(Double boxqty) {
		this.boxqty = boxqty;
	}
	public Double getStripqty() {
		return stripqty;
	}
	public void setStripqty(Double stripqty) {
		this.stripqty = stripqty;
	}
	public Double getTabqty() {
		return tabqty;
	}
	public void setTabqty(Double tabqty) {
		this.tabqty = tabqty;
	}
	public Double getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}
	public int getFromlocname() {
		return fromlocname;
	}
	public void setFromlocname(int fromlocname) {
		this.fromlocname = fromlocname;
	}
	public int getFromlocrefid() {
		return fromlocrefid;
	}
	public void setFromlocrefid(int fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}
	public int getTolocrefid() {
		return tolocrefid;
	}
	public void setTolocrefid(int tolocrefid) {
		this.tolocrefid = tolocrefid;
	}
	public int getTolocname() {
		return tolocname;
	}
	public void setTolocname(int tolocname) {
		this.tolocname = tolocname;
	}
	public int getCompanyrefid() {
		return companyrefid;
	}
	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}
	public int getBranchrefid() {
		return branchrefid;
	}
	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
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
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
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
	public int getBilltyperefid() {
		return billtyperefid;
	}
	public void setBilltyperefid(int billtyperefid) {
		this.billtyperefid = billtyperefid;
	}
	public int getBatchrefid() {
		return batchrefid;
	}
	public void setBatchrefid(int batchrefid) {
		this.batchrefid = batchrefid;
	}
	public int getStockno() {
		return stockno;
	}
	public void setStockno(int stockno) {
		this.stockno = stockno;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getSalesorderrefid() {
		return salesorderrefid;
	}
	public void setSalesorderrefid(int salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public String getStripperbox() {
		return stripperbox;
	}
	public void setStripperbox(String stripperbox) {
		this.stripperbox = stripperbox;
	}
	public String getQuantityperstrip() {
		return quantityperstrip;
	}
	public void setQuantityperstrip(String quantityperstrip) {
		this.quantityperstrip = quantityperstrip;
	}
	public String getPackageunit() {
		return packageunit;
	}
	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}
	
}
