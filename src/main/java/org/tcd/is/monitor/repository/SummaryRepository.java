package org.tcd.is.monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcd.is.monitor.model.entities.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Long>{

	public Summary findByAgentId(Long id);
}
