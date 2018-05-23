package org.tcd.is.monitor.model.dto;

public class Status {
	
	private Long agentId;
	
	private Long energyGeneration;
	
	private Long energyConsumption;

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getEnergyGeneration() {
		return energyGeneration;
	}

	public void setEnergyGeneration(Long energyGeneration) {
		this.energyGeneration = energyGeneration;
	}

	public Long getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(Long energyConsumption) {
		this.energyConsumption = energyConsumption;
	}
}
