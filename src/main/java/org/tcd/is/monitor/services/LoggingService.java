package org.tcd.is.monitor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcd.is.monitor.model.dto.IterationLogDto;
import org.tcd.is.monitor.model.entities.Agent;
import org.tcd.is.monitor.model.entities.IterationLog;
import org.tcd.is.monitor.repository.IterationLogRepository;

@Service
public class LoggingService {

	@Autowired
	IterationLogRepository iterationLogRepository;
	
	@Autowired
	AgentService agentService;
	
	public void logIterationStatus(IterationLogDto iterationLogDto) {
		IterationLog iterationLog = new IterationLog();
		
		Agent agent = agentService.getAgent(iterationLogDto.getAgentId());
		iterationLog.setAgent(agent);
		
		iterationLog.setIteration(iterationLogDto.getIteration());
		iterationLog.setEnergyConsumption(iterationLogDto.getEnergyConsumption());
		iterationLog.setEnergyGeneration(iterationLogDto.getEnergyGeneration());
		iterationLog.setEnergyBorrowedFromAlly(iterationLogDto.getEnergyBorrowedFromAlly());
		iterationLog.setEnergyBorrowedFromCG(iterationLogDto.getEnergyBorrowedFromCG());
		iterationLog.setNzebStatus(iterationLogDto.getNzebStatus());
		
		iterationLogRepository.save(iterationLog);
	}
}
