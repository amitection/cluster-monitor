package org.tcd.is.monitor.model.dto;

public class Status {
	
	private String timestamp;
	
	private Long agentId;
	
	private Long iter;
	
	private Double batteryInitial;
	
	private Double energyConsumption;
	
	private Double energyGeneration;
	
	private Double borrowedFromCG;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getIter() {
		return iter;
	}

	public void setIter(Long iter) {
		this.iter = iter;
	}

	public Double getBatteryInitial() {
		return batteryInitial;
	}

	public void setBatteryInitial(Double batteryInitial) {
		this.batteryInitial = batteryInitial;
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

	public Double getBorrowedFromCG() {
		return borrowedFromCG;
	}

	public void setBorrowedFromCG(Double borrowedFromCG) {
		this.borrowedFromCG = borrowedFromCG;
	}
}
