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
public class IterationLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long iteration;
	
	private Date timestamp;
	
	@JsonIdentityReference(alwaysAsId=true)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="agent_id", nullable=false)
	private Agent agent;
	
	private Double energyConsumption;
	
	private Double energyGeneration;
	
	private Double energyBorrowedFromAlly;
	
	private Double energyBorrowedFromCG;
	
	private Double nzebStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIteration() {
		return iteration;
	}

	public void setIteration(Long iteration) {
		this.iteration = iteration;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Double getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(Double energyConsumption) {
		this.energyConsumption = energyConsumption;
	}

	public Double getEnergyGeneration() {
		return energyGeneration;
	}

	public void setEnergyGeneration(Double energyGeneration) {
		this.energyGeneration = energyGeneration;
	}

	public Double getEnergyBorrowedFromAlly() {
		return energyBorrowedFromAlly;
	}

	public void setEnergyBorrowedFromAlly(Double energyBorrowedFromAlly) {
		this.energyBorrowedFromAlly = energyBorrowedFromAlly;
	}

	public Double getEnergyBorrowedFromCG() {
		return energyBorrowedFromCG;
	}

	public void setEnergyBorrowedFromCG(Double energyBorrowedFromCG) {
		this.energyBorrowedFromCG = energyBorrowedFromCG;
	}

	public Double getNzebStatus() {
		return nzebStatus;
	}

	public void setNzebStatus(Double nzebStatus) {
		this.nzebStatus = nzebStatus;
	}

}
