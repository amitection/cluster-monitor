package org.tcd.is.monitor.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, nullable= false)
	private String name;
	
	@Column(unique=true, nullable= false)
	private String msgQueueName;
	
	private boolean active;
	
	@JsonIgnore
	@OneToOne(mappedBy="agent", fetch=FetchType.LAZY)
	private Summary status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsgQueueName() {
		return msgQueueName;
	}

	public void setMsgQueueName(String msgQueueName) {
		this.msgQueueName = msgQueueName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
