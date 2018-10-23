package com.worksplit.tables;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

public class GroupTasks {
	@Id
	@Column(name = "group_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groupId;
	
	@Column(name = "task_id")
	private Integer taskId;
	
	@Column(name = "assigned_by")
	private Integer assignedBy;
	
	@Column(name = "assigned_on")
	@CreationTimestamp
	private Timestamp assignedOn;
	
	@Column(name = "last_updated_on")
	@UpdateTimestamp
	private Timestamp lastUpdatedOn;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	

	@Column(name = "valid_till")
	private DateTimeFormat date;


	public GroupTasks(Integer groupId, Integer taskId, Integer assignedBy, Timestamp assignedOn,
			Timestamp lastUpdatedOn, Boolean isDeleted, DateTimeFormat date) {
		super();
		this.groupId = groupId;
		this.taskId = taskId;
		this.assignedBy = assignedBy;
		this.assignedOn = assignedOn;
		this.lastUpdatedOn = lastUpdatedOn;
		this.isDeleted = isDeleted;
		this.date = date;
	}


	public Integer getGroupId() {
		return groupId;
	}


	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}


	public Integer getTaskId() {
		return taskId;
	}


	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}


	public Integer getAssignedBy() {
		return assignedBy;
	}


	public void setAssignedBy(Integer assignedBy) {
		this.assignedBy = assignedBy;
	}


	public Timestamp getAssignedOn() {
		return assignedOn;
	}


	public void setAssignedOn(Timestamp assignedOn) {
		this.assignedOn = assignedOn;
	}


	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}


	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}


	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public DateTimeFormat getDate() {
		return date;
	}


	public void setDate(DateTimeFormat date) {
		this.date = date;
	}
	
	
	
	
	
	

}
