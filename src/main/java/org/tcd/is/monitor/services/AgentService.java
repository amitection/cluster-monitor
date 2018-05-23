package org.tcd.is.monitor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcd.is.monitor.model.entities.Agent;
import org.tcd.is.monitor.repository.AgentRepository;

@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	public Agent getAgent(Long agentId) {
		return agentRepository.findOne(agentId);
	}
	
	public List<Agent> getActiveAgents() {
		return agentRepository.findByActive(true);
	}
}
