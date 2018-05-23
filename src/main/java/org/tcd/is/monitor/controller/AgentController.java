package org.tcd.is.monitor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tcd.is.monitor.model.entities.Agent;
import org.tcd.is.monitor.services.AgentService;
import org.tcd.is.monitor.services.RegistrationService;
import org.tcd.is.monitor.utils.JsonUtils;

@RestController
@RequestMapping(value = "/agent")
public class AgentController {

	Logger logger = LoggerFactory.getLogger(AgentController.class);
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	RegistrationService registrationService;
	
	
	@RequestMapping(path="/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> sendMessage(@RequestBody Agent agent) {
		
		agent = registrationService.register(agent);
		logger.info("Agent (name: "+agent.getName()+" id: "+agent.getId()+") registered successfully.");
		return JsonUtils.getJsonForResponse(agent);
	}
	
	
	@RequestMapping(path="/active", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getActiveAgents() {
		
		List<Agent> agents = agentService.getActiveAgents();
		logger.info("Fetched list of active agents successfully.");
		return JsonUtils.getJsonForResponse(agents);
	}
	
}
