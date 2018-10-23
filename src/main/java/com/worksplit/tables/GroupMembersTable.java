package com.worksplit.tables;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name = "groups_members")
public class GroupMembersTable{
	
	@Id
	@GeneratedValue()
	@Column(name = "group_id")
	private Integer groupId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "invitation_status")
	private Integer invitationStatus;
	
	@Column(name = "invitation_sent_by")
	private Integer invitationSentBy;
	
	@Column(name = "joined_on")
	@CreationTimestamp
	private Timestamp joinedOn;
	
	@Column(name = "left_on")
	@UpdateTimestamp
	private Timestamp leftOn;
	
	public GroupMembersTable() {
	
	}

	public GroupMembersTable(Integer groupId, Integer userId, Integer invitationStatus, Integer invitationSentBy,
			Timestamp joinedOn, Timestamp leftOn) {
		super();
		this.groupId = groupId;
		this.userId = userId;
		this.invitationStatus = invitationStatus;
		this.invitationSentBy = invitationSentBy;
		this.joinedOn = joinedOn;
		this.leftOn = leftOn;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getInvitationStatus() {
		return invitationStatus;
	}

	public void setInvitationStatus(Integer invitationStatus) {
		this.invitationStatus = invitationStatus;
	}

	public Integer getInvitationSentBy() {
		return invitationSentBy;
	}

	public void setInvitationSentBy(Integer invitationSentBy) {
		this.invitationSentBy = invitationSentBy;
	}

	public Timestamp getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(Timestamp joinedOn) {
		this.joinedOn = joinedOn;
	}

	public Timestamp getLeftOn() {
		return leftOn;
	}

	public void setLeftOn(Timestamp leftOn) {
		this.leftOn = leftOn;
	}
	
	
	

}
