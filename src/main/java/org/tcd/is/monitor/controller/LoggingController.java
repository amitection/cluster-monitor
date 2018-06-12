package org.tcd.is.monitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tcd.is.monitor.model.dto.IterationLogDto;
import org.tcd.is.monitor.services.LoggingService;

@RestController
@RequestMapping(value = "/energy/log")
public class LoggingController {
	
	Logger logger = LoggerFactory.getLogger(LoggingController.class);
	
	@Autowired
	private LoggingService loggingService;
	
	@RequestMapping(path="/iteration/status", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> logEnergyTransaction(@RequestBody IterationLogDto ilDto) {
		
		loggingService.logIterationStatus(ilDto);
		logger.info("Energy status for iteration ("+ilDto.getIteration()+") "
				+ "by Agent (agent_id: "+ilDto.getAgentId()+") logged successfully.");
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
