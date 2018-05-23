package org.tcd.is.monitor.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcd.is.monitor.model.dto.Status;
import org.tcd.is.monitor.model.entities.Agent;
import org.tcd.is.monitor.model.entities.Summary;
import org.tcd.is.monitor.repository.SummaryRepository;

@Service
public class EnergyStatusService {

	@Autowired
	private SummaryRepository summaryRepository;
	
	public void updateEnergyStatus(Status status) {
		Summary summary = summaryRepository.findByAgentId(status.getAgentId());
		summary.setConsumption(summary.getConsumption() + status.getEnergyConsumption());
		summary.setGeneration(summary.getGeneration() + status.getEnergyGeneration());
		
		summaryRepository.save(summary);
	}
	
	public Summary getEnergyStatus(Long agentId) {
		Summary summary = summaryRepository.findByAgentId(agentId);
		return summary;
	}
	
	@Transactional
	public void createNewEntry(Agent agent) {
		Summary summary = new Summary();
		summary.setAgent(agent);
		summary.setConsumption(0L);
		summary.setGeneration(0L);
		
		summaryRepository.save(summary);
	}
}
