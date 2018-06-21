package org.tcd.is.monitor.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcd.is.monitor.model.dto.Status;
import org.tcd.is.monitor.model.entities.Agent;
import org.tcd.is.monitor.model.entities.Summary;
import org.tcd.is.monitor.repository.SummaryRepository;

@Service
public class EnergyStatusService {

	Logger logger = LoggerFactory.getLogger(EnergyStatusService.class);

	@Autowired
	private SummaryRepository summaryRepository;
	
	@Autowired
	AgentService agentService;

	@Transactional
	public void updateEnergyStatus(Status status) {
		Summary summary = summaryRepository.findByAgentIdAndIter(status.getAgentId(), status.getIter());
		
		if(summary == null) {
			// Get reference to agent
			Agent agent = agentService.getAgent(status.getAgentId());
			
			// Create a new summary entry
			summary = createNewEntry(agent, status.getIter(), status.getBatteryInitial());
		}

		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date timestamp = df.parse(status.getTimestamp());
			summary.setTimestamp(timestamp);
		} catch (ParseException e) {
			logger.error("", e);
		}
	
		summary.setConsumption(summary.getConsumption() + status.getEnergyConsumption());
		summary.setGeneration(summary.getGeneration() + status.getEnergyGeneration());
		summary.setBorrowedFromCG(summary.getBorrowedFromCG() + status.getBorrowedFromCG());

		summaryRepository.save(summary);
	}

	
	public List<Summary> getEnergyStatus(Long agentId) {
		List<Summary> summary = summaryRepository.findByAgentId(agentId);
		return summary;
	}
	

	@Transactional
	public Summary createNewEntry(Agent agent, Long iteration, Double batteryInitial) {
		Summary summary = new Summary();
		summary.setAgent(agent);
		summary.setIter(iteration);
		summary.setBatteryInitial(batteryInitial);
		summary.setConsumption(0.0);
		summary.setGeneration(0.0);
		summary.setBorrowedFromCG(0.0);

		return summaryRepository.save(summary);
	}
	

	public Summary getGridStatus(Long iter) {
		List<Summary> summaries = summaryRepository.findByIter(iter);
		
		Summary gridStatus = new Summary();
		gridStatus.setConsumption(0.0);
		gridStatus.setGeneration(0.0);
		gridStatus.setBorrowedFromCG(0.0);
		
		for (Summary agentSummary : summaries) {
			gridStatus.setConsumption(gridStatus.getConsumption() + agentSummary.getConsumption());
			gridStatus.setGeneration(gridStatus.getGeneration() + agentSummary.getGeneration());
			gridStatus.setBorrowedFromCG(gridStatus.getBorrowedFromCG() + agentSummary.getBorrowedFromCG());
		}

		gridStatus.setId(-1L);

		return gridStatus;
	}
}
