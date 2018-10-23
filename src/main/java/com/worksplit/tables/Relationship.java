package com.worksplit.tables;

import javax.persistence.*;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Entity
@Table(name = "relationship")
@Component
public class Relationship implements Serializable {

	private static final long serialVersionUID = 1L;

	// Empty constructor for jackson to deserialize object
	public Relationship() {

	}

	@Id
	@Column(name = "user_one_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userOneId;

	@Id
	@Column(name = "user_two_id")
	private Integer userTwoId;

	@Column(name = "status")
	private Integer status;

	@Column(name = "action_user_id")
	private Integer actionUserId;

	public Relationship(Integer userOneId, Integer userTwoId, Integer status, Integer actionUserId) {
		this.userOneId = userOneId;
		this.userTwoId = userTwoId;
		this.status = status;
		this.actionUserId = actionUserId;

	}

	public Integer getUserOneId() {
		return userOneId;
	}

	public void setUserOneId(Integer userOneId) {
		this.userOneId = userOneId;
	}

	public Integer getUserTwoId() {
		return userTwoId;
	}

	public void setUserTwoId(Integer userTwoId) {
		this.userTwoId = userTwoId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(Integer actionUserId) {
		this.actionUserId = actionUserId;
	}

}
