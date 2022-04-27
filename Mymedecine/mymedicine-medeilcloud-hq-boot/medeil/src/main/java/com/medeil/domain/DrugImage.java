package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//soundharya
@Entity
@Table(name = "medc_custproductmasterimages", catalog = "medc_productmaster")
public class DrugImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageid") 
	private Integer id;

	private String image_url;
	private String image_filename;
	private Integer drugproductid;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getImage_filename() {
		return image_filename;
	}
	public void setImage_filename(String image_filename) {
		this.image_filename = image_filename;
	}
	public Integer getDrugproductid() {
		return drugproductid;
	}
	public void setDrugproductid(Integer drugproductid) {
		this.drugproductid = drugproductid;
	}
}
