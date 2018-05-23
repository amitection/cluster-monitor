package org.tcd.is.monitor.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcd.is.monitor.model.entities.Agent;
import org.tcd.is.monitor.repository.AgentRepository;

@Service
public class RegistrationService {

	Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	EnergyStatusService energyStatusService;
	
	@Transactional
	public Agent register(Agent agent) {
		
		Agent dbAgent = agentRepository.findByName(agent.getName());
		
		// If agent already present then return this agent
		if(dbAgent != null) {
			agent = dbAgent;
			logger.debug("Agent (name: "+agent.getName()+" id: "+agent.getId()+") already present.");
		} else {
			// Create a new agent
			agent = agentRepository.save(agent);
			energyStatusService.createNewEntry(agent);
			logger.debug("New Agent (name: "+agent.getName()+" id: "+agent.getId()+") registered successfully.");
		}
		
		return agent;
	}
}
