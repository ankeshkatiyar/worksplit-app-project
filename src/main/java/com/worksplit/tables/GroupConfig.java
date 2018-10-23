package com.worksplit.tables;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@ApiModel
@Table(name = "groups_master")
public class GroupConfig {
	
	@Column(name = "group_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = false ,hidden = true)
	private Integer groupId;

	@ApiModelProperty(required = true , value = "groupName" ,position = 1)
	@Column(name = "group_name")
	private String groupName;

    @Column(name = "group_type")
    @ApiModelProperty(required = true ,position = 2)
    private String groupType;

    @Column(name = "group_description")
    @ApiModelProperty(required = true ,position = 3)
    private String groupDescription;

    @Column(name = "created_by", updatable = false)
    @ApiModelProperty(required = true , position = 4)
    private Integer createdBy;

    @Column(name= "last_updated_by")
    @ApiModelProperty(required = true ,position = 5)
    private Integer lastUpdatedBy;

    @Column(name = "device")
    @ApiModelProperty(required = true ,position = 6)
    private String device;

    @Column(name = "is_deleted")
    @ApiModelProperty(hidden = true)
    private Boolean isDeleted;

    @CreationTimestamp
	@Column(name = "created_on" ,updatable = false)
    @ApiModelProperty(hidden = true)
	private  Timestamp createdOn;

	@Column(name= "last_updated_on")
	@UpdateTimestamp
    @ApiModelProperty(required = false ,hidden = true)
	private Timestamp lastUpdatedOn;
	


	public GroupConfig() {
		
	}
	
	public GroupConfig(Integer groupId, String groupName, Timestamp createdOn, Integer createdBy, String groupType,
                       String groupDescription, String device, Integer lastUpdatedBy, Timestamp lastUpdatedOn , Boolean isDeleted) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.groupType = groupType;
		this.groupDescription = groupDescription;
		this.device = device;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedOn = lastUpdatedOn;
		this.isDeleted = isDeleted;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
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

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return groupName;
	}
}
