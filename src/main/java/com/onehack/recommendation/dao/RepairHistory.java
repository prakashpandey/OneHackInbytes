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

/**
 * 
 * @author Prakash Pandey 09-Dec-2017
 *
 */

@Entity
@Table(name = "repair_history")
public class RepairHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "user.id")
	private User user;

	@Column(name = "model_id")
	private Integer modelId;

	@Column(name = "insurance_claimed")
	private Integer insuranceClaimed;

	@Column(name = "customer_cost")
	private Integer customerCost;

	@Column(name = "total_cost")
	private Integer totalCost;

	@Column(name = "request_raised")
	@DateTimeFormat(style = "yyyy-MM-dd")
	private Date requestRaised;

	@Column(name = "request_completed")
	@DateTimeFormat(style = "yyyy-MM-dd")
	private Date requestCompleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getInsuranceClaimed() {
		return insuranceClaimed;
	}

	public void setInsuranceClaimed(Integer insuranceClaimed) {
		this.insuranceClaimed = insuranceClaimed;
	}

	public Integer getCustomerCost() {
		return customerCost;
	}

	public void setCustomerCost(Integer customerCost) {
		this.customerCost = customerCost;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public Date getRequestRaised() {
		return requestRaised;
	}

	public void setRequestRaised(Date requestRaised) {
		this.requestRaised = requestRaised;
	}

	public Date getRequestCompleted() {
		return requestCompleted;
	}

	public void setRequestCompleted(Date requestCompleted) {
		this.requestCompleted = requestCompleted;
	}

	@Override
	public String toString() {
		return "RepairHistory [id=" + id + ", user=" + user + ", modelId=" + modelId + ", insuranceClaimed="
				+ insuranceClaimed + ", customerCost=" + customerCost + ", totalCost=" + totalCost + ", requestRaised="
				+ requestRaised + ", requestCompleted=" + requestCompleted + "]";
	}
}
