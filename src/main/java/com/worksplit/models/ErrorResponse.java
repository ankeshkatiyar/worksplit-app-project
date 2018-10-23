package com.worksplit.models;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {

	@ApiModelProperty(required = true , value = "Error Code")
	private Integer errorCode;

    @ApiModelProperty(required = true , value = "Error")
	private String error;

    @ApiModelProperty(required = true , value = "Time Stamp")
	private long timestamp;

    @ApiModelProperty(required = true , value = "User Id")
	private String UserId;

    @ApiModelProperty(required = true , value = "Device")
	private String device;

	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	
}
