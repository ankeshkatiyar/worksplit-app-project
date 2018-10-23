package com.worksplit.models;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worksplit.utils.StatusCodes;

@Component
public class RelationshipModel {

	public RelationshipModel() {

	}

	@JsonProperty(value = "userOneId")
	private Integer userOneId;

	@JsonProperty(value = "userTwoId")
	private Integer userTwoId;

	@JsonProperty(value = "status")
	private Integer status;

	@JsonProperty(value = "actionUserId")
	private Integer actionUserId;

	@JsonProperty(value = "emailorphone")
	private String emailOrPhone;

	private StatusCodes error;

	public RelationshipModel(Integer userOneId, Integer userTwoId, Integer status, Integer actionUserId,
			String emailOrPhone, StatusCodes error) {
		this.userOneId = userOneId;
		this.userTwoId = userTwoId;
		this.status = status;
		this.actionUserId = actionUserId;
		this.emailOrPhone = emailOrPhone;
		this.error = error;
	}

	public StatusCodes getError() {
		return error;
	}

	public void setError(StatusCodes error) {
		this.error = error;
	}

	public String getEmailOrPhone() {
		return emailOrPhone;
	}

	public void setEmailOrPhone(String emailOrPhone) {
		this.emailOrPhone = emailOrPhone;
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
