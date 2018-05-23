package org.tcd.is.monitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tcd.is.monitor.model.dto.Status;
import org.tcd.is.monitor.model.entities.Summary;
import org.tcd.is.monitor.services.EnergyStatusService;
import org.tcd.is.monitor.utils.JsonUtils;

@RestController
@RequestMapping(value = "/energy/trasaction")
public class EnergyStatusController {

	Logger logger = LoggerFactory.getLogger(EnergyStatusController.class);
	
	@Autowired
	private EnergyStatusService energyStatusService;
	
	/**
	 * Method that updates the Summary table with the latest Energy information sent by a Agent
	 * @param status
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateEnergyStatus(@RequestBody Status status) {
		
		energyStatusService.updateEnergyStatus(status);
		logger.info("Energy status for agent ("+status.getAgentId()+") updated successfully.");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@RequestMapping(path="/{agentid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getEnergyStatus(@PathVariable(name="agentid") Long agentId) {
		
		Summary summary = energyStatusService.getEnergyStatus(agentId);
		logger.info("Request to get energy status for agent ("+agentId+") processed successfully.");
		return JsonUtils.getJsonForResponse(summary);
	}
}
