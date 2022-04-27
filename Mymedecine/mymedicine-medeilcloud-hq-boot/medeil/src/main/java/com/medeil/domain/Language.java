package com.medeil.domain;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "medc_language", catalog = "medc_productmaster")
//*Maha*//
public class Language
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "langid")


		private Integer id;
		private Integer productid;
		private Integer actionindicationid;
		private String actionindicationenglish;
		private String actionindicationburmese;
		private Integer productinformationid;
		private String productinformationenglish;
		private String productinformationburmese;
		private Integer potentialsideeffectsid;
		private String potentialsideeffectsenglish;
		private String potentialsideeffectsburmese;
		private Integer companyrefid;
		private Integer branchid;
		private Integer locname;
		private Integer locrefid;
		private String createdby;
		private String createddate;
		private String modifyby;
		private String modifydate;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getProductid() {
			return productid;
		}
		public void setProductid(Integer productid) {
			this.productid = productid;
		}
		public Integer getActionindicationid() {
			return actionindicationid;
		}
		public void setActionindicationid(Integer actionindicationid) {
			this.actionindicationid = actionindicationid;
		}
		public String getActionindicationenglish() {
			return actionindicationenglish;
		}
		public void setActionindicationenglish(String actionindicationenglish) {
			this.actionindicationenglish = actionindicationenglish;
		}
		public String getActionindicationburmese() {
			return actionindicationburmese;
		}
		public void setActionindicationburmese(String actionindicationburmese) {
			this.actionindicationburmese = actionindicationburmese;
		}
		public Integer getProductinformationid() {
			return productinformationid;
		}
		public void setProductinformationid(Integer productinformationid) {
			this.productinformationid = productinformationid;
		}
		public String getProductinformationenglish() {
			return productinformationenglish;
		}
		public void setProductinformationenglish(String productinformationenglish) {
			this.productinformationenglish = productinformationenglish;
		}
		public String getProductinformationburmese() {
			return productinformationburmese;
		}
		public void setProductinformationburmese(String productinformationburmese) {
			this.productinformationburmese = productinformationburmese;
		}
		public Integer getPotentialsideeffectsid() {
			return potentialsideeffectsid;
		}
		public void setPotentialsideeffectsid(Integer potentialsideeffectsid) {
			this.potentialsideeffectsid = potentialsideeffectsid;
		}
		public String getPotentialsideeffectsenglish() {
			return potentialsideeffectsenglish;
		}
		public void setPotentialsideeffectsenglish(String potentialsideeffectsenglish) {
			this.potentialsideeffectsenglish = potentialsideeffectsenglish;
		}
		public String getPotentialsideeffectsburmese() {
			return potentialsideeffectsburmese;
		}
		public void setPotentialsideeffectsburmese(String potentialsideeffectsburmese) {
			this.potentialsideeffectsburmese = potentialsideeffectsburmese;
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
		public String getModifyby() {
			return modifyby;
		}
		public void setModifyby(String modifyby) {
			this.modifyby = modifyby;
		}
		public String getModifydate() {
			return modifydate;
		}
		public void setModifydate(String modifydate) {
			this.modifydate = modifydate;
		}
		
		
	}