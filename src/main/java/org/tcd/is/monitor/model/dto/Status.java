package org.tcd.is.monitor.model.dto;

public class Status {
	
	private String timestamp;
	
	private Long agentId;
	
	private Double energyGeneration;
	
	private Double energyConsumption;

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

	public Double getEnergyGeneration() {
		return energyGeneration;
	}

	public void setEnergyGeneration(Double energyGeneration) {
		this.energyGeneration = energyGeneration;
	}

	public Double getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(Double energyConsumption) {
		this.energyConsumption = energyConsumption;
	}
}
