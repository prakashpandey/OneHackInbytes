package com.onehack.recommendation.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product_purchase")
public class ProductPurchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user.id")
	private User users;

	@Column(name = "brand")
	private String brand;

	@Column(name = "category")
	private String category;

	@Column(name = "model")
	private String model;

	@Column(name = "price")
	private Integer price;

	@Column(name = "bought_on")
	@DateTimeFormat(style="yyyy-MM-dd")
	private Date boughtOn;

	@Column(name = "insurance_price")
	private Integer insurancePrice;

	@Column(name = "average_service_interval")
	private long averageServiceInterval;

	@Column(name = "average_service_cost")
	private long averageServiceCost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return users;
	}

	public void setUser(User user) {
		this.users = user;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getBoughtOn() {
		return boughtOn;
	}

	public void setBoughtOn(Date boughtOn) {
		this.boughtOn = boughtOn;
	}

	public Integer getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Integer insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public long getAverageServiceInterval() {
		return averageServiceInterval;
	}

	public void setAverageServiceInterval(long averageServiceInterval) {
		this.averageServiceInterval = averageServiceInterval;
	}

	public long getAverageServiceCost() {
		return averageServiceCost;
	}

	public void setAverageServiceCost(long averageServiceCost) {
		this.averageServiceCost = averageServiceCost;
	}

	@Override
	public String toString() {
		return "ProductPurchase [id=" + id + ", user=" + users + ", brand=" + brand + ", category=" + category
				+ ", model=" + model + ", price=" + price + ", boughtOn=" + boughtOn + ", insurancePrice="
				+ insurancePrice + ", averageServiceInterval=" + averageServiceInterval + ", averageServiceCost="
				+ averageServiceCost + "]";
	}
}
