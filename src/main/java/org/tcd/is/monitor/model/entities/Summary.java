package org.tcd.is.monitor.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Summary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long iter;
	
	private Date timestamp;
	
	private Double batteryInitial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="agent_id", nullable=false)
	private Agent agent;
	
	private Double generation;
	
	private Double consumption;
	
	private Double borrowedFromCG;

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

	public Double getBatteryInitial() {
		return batteryInitial;
	}

	public void setBatteryInitial(Double batteryInitial) {
		this.batteryInitial = batteryInitial;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Double getGeneration() {
		return generation;
	}

	public void setGeneration(Double generation) {
		this.generation = generation;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	public Double getBorrowedFromCG() {
		return borrowedFromCG;
	}

	public void setBorrowedFromCG(Double borrowedFromCG) {
		this.borrowedFromCG = borrowedFromCG;
	}
}
