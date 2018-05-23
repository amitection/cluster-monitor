package org.tcd.is.monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcd.is.monitor.model.entities.EnergyTransaction;

public interface EnergyTransactionRepository extends JpaRepository<EnergyTransaction, Long>{

}
