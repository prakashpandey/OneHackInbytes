package com.onehack.recommendation.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Prakash Pandey 09-Dec-2017
 *
 */
@Entity
@Table(name = "product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model_number")
	private Integer modelNumber;
	
	@Column(name = "cost")
	private Integer cost;
	
	@Column(name = "meta_info")
	private String metaInfo;
	
	@Column(name = "purchased_count")
	private Integer purchasedCount;

	public Integer getPurchasedCount() {
		return purchasedCount;
	}

	public void setPurchasedCount(Integer purchasedCount) {
		this.purchasedCount = purchasedCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(Integer modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", brand=" + brand
				+ ", modelNumber=" + modelNumber + ", cost=" + cost + ", metaInfo=" + metaInfo + "]";
	}
	
	
	
}
