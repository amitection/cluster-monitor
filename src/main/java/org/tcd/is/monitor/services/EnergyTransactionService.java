package org.tcd.is.monitor.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tcd.is.monitor.model.dto.EnergyTransactionDto;
import org.tcd.is.monitor.model.entities.EnergyTransaction;
import org.tcd.is.monitor.repository.AgentRepository;
import org.tcd.is.monitor.repository.EnergyTransactionRepository;

@Service
public class EnergyTransactionService {

	Logger logger = LoggerFactory.getLogger(EnergyTransactionService.class);
	
	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private EnergyTransactionRepository etRepository;

	@Transactional
	public EnergyTransaction saveTransaction(EnergyTransactionDto transactionDto) {

		EnergyTransaction et = new EnergyTransaction();

		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date timestamp = df.parse(transactionDto.getTimestamp());
			et.setTimestamp(timestamp);
		} catch (ParseException e) {
			logger.error("",e);
		}

		et.setSeller(agentRepository.findOne(transactionDto.getSellerId()));
		et.setBuyer(agentRepository.findOne(transactionDto.getBuyerId()));
		et.setAmount(transactionDto.getAmount());
		et.setPrice(transactionDto.getPrice());

		et = etRepository.save(et);

		return et;
	}
}
