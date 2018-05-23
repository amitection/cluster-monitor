package org.tcd.is.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcd.is.monitor.model.entities.Agent;

public interface AgentRepository  extends JpaRepository<Agent, Long> {
	
	public Agent findByName(String name);
	
	public List<Agent> findByActive(boolean active);
}
