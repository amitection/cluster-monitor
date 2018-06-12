package org.tcd.is.monitor.model.dto;

public class IterationLogDto {

	private Long agentId;
	
	private Long iteration;

	private Double energyConsumption;

	private Double energyGeneration;

	private Double energyBorrowedFromAlly;

	private Double energyBorrowedFromCG;

	private Double nzebStatus;

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getIteration() {
		return iteration;
	}

	public void setIteration(Long iteration) {
		this.iteration = iteration;
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
