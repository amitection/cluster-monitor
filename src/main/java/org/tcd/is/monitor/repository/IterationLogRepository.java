package org.tcd.is.monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcd.is.monitor.model.entities.IterationLog;

public interface IterationLogRepository  extends JpaRepository<IterationLog, Long>{

}
