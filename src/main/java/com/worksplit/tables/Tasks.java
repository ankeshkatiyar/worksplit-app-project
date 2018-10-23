package com.worksplit.tables;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tasks")
public class Tasks implements Serializable {

	private static final long serialVersionUID = 1L;

	public  Tasks() {
		
	}
	@Column(name = "task_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	@Column(name = "task_name")
	@JsonProperty("task_name")
	private String taskName;
	
	@CreationTimestamp
	@Column(name = "created_on")
	private Timestamp createdOn;
	
	@Column(name = "created_by")
	@JsonProperty("created_by")
	private String createdBy;
	
	@Column(name = "frequency")
	@JsonProperty("frequency")
	private int frequency;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	
	

	public Tasks(Integer taskId, String taskName, Timestamp createdOn, String createdBy, int frequency,
			String description) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.frequency = frequency;
		this.description = description;
	}



	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return taskName;
	}
	
}
