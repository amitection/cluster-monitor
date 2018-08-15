package org.tcd.is.monitor.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class EnergyTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long iter;
	
	private Date timestamp;
	
	@JsonIdentityReference(alwaysAsId=true)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="seller_id", nullable=false)
	private Agent seller;
	
	@JsonIdentityReference(alwaysAsId=true)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="buyer_id", nullable=false)
	private Agent buyer;
	
	private Double price;
	
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIter() {
		return iter;
	}

	public void setIter(Long iter) {
		this.iter = iter;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Agent getSeller() {
		return seller;
	}

	public void setSeller(Agent seller) {
		this.seller = seller;
	}

	public Agent getBuyer() {
		return buyer;
	}

	public void setBuyer(Agent buyer) {
		this.buyer = buyer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
