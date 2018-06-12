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

	public void updateEnergyStatus(Status status) {
		Summary summary = summaryRepository.findByAgentId(status.getAgentId());

		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date timestamp = df.parse(status.getTimestamp());
			summary.setTimestamp(timestamp);
		} catch (ParseException e) {
			logger.error("", e);
		}

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
		summary.setConsumption(0.0);
		summary.setGeneration(0.0);

		summaryRepository.save(summary);
	}

	public Summary getGridStatus() {
		List<Summary> summaries = summaryRepository.findAll();
		Summary gridStatus = new Summary();
		gridStatus.setConsumption(0.0);
		gridStatus.setGeneration(0.0);
		for (Summary agentSummary : summaries) {
			gridStatus.setConsumption(gridStatus.getConsumption() + agentSummary.getConsumption());
			gridStatus.setGeneration(gridStatus.getGeneration() + agentSummary.getGeneration());
		}

		gridStatus.setId(-1L);

		return gridStatus;
	}
}
