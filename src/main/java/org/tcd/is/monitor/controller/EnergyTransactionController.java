package org.tcd.is.monitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tcd.is.monitor.model.dto.EnergyTransactionDto;
import org.tcd.is.monitor.model.entities.EnergyTransaction;
import org.tcd.is.monitor.services.EnergyTransactionService;
import org.tcd.is.monitor.utils.JsonUtils;

@RestController
@RequestMapping(value = "/energy/trasaction")
public class EnergyTransactionController {

	Logger logger = LoggerFactory.getLogger(EnergyTransactionController.class);
	
	@Autowired
	private EnergyTransactionService etService;
	
	/**
	 * This controller method logs a transaction information updated by the seller. As a buyer can buy energy
	 * from multiple sellers.
	 * @param transaction
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> logEnergyTransaction(@RequestBody EnergyTransactionDto transaction) {
		
		EnergyTransaction et = etService.saveTransaction(transaction);
		logger.info("Energy transaction (transaction_id"+et.getId()+") "
				+ "by seller Agent (agent_id: "+et.getSeller()+") logged successfully.");
		return JsonUtils.getJsonForResponse(et);
	}
}
