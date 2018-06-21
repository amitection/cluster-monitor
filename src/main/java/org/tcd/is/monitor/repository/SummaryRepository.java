package org.tcd.is.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcd.is.monitor.model.entities.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Long>{

	public List<Summary> findByAgentId(Long id);
	
	public Summary findByAgentIdAndIter(Long id, Long iter);
	
	public List<Summary> findByIter(Long iter);
}
