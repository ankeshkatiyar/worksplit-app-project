//package com.worksplit.tables;
//
//import java.io.Serializable;
//import java.sql.Timestamp;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import io.swagger.annotations.ApiModelProperty;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.stereotype.Component;
//
//@Entity
//@Table(name = "users")
//@Component
//public class User<a> implements Serializable {
//	private static final long serialVersionUID = -8769095109382818846L;
//
//	public User() {
//
//	}
//
//	public User(String name, String email, String mob, String device, String password ) {
//		this.name = name;
//		this.email = email;
//		this.mob = mob;
//		this.device = device;
//		this.password = password;
//
//	}
//
//	@Id
//	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(hidden = true)
//	private Integer userId;
//
//
//	@Column(name = "email")
//	@NotNull
//	@NotEmpty
//    @ApiModelProperty(position = 1)
//	private String email;
//
//	@Column(name = "name")
//	@NotNull
//	@NotEmpty
//    @ApiModelProperty(position = 3)
//	private String name;
//
//	@Column(name = "mob")
//	@NotNull
//	@NotEmpty
//    @ApiModelProperty(position = 4)
//	private String mob;
//
//	@Column(name = "password")
//	@NotNull
//	@NotEmpty
//    @ApiModelProperty(position = 2)
//	private String password;
//
//	@CreationTimestamp
//	@Column(name = "createdon")
//	@ApiModelProperty(hidden = true)
//	private Timestamp createdon;
//
//	@Column(name = "device")
//	@NotNull
//	@NotEmpty
//    @ApiModelProperty(position = 5)
//	private String device;
//
//	@Column(name = "lastlogin")
//    @JsonIgnoreProperties
//	@UpdateTimestamp
//    @ApiModelProperty(hidden = true)
//	private Timestamp lastlogin;
//
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@Id
//	public void setMob(String mob) {
//		this.mob = mob;
//	}
//
//	public void setCreatedon(Timestamp createdon) {
//		this.createdon = createdon;
//	}
//
//	public void setDevice(String device) {
//		this.device = device;
//	}
//
//	public void setLastlogin(Timestamp lastlogin) {
//		this.lastlogin = lastlogin;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public String getMob() {
//		return mob;
//	}
//
//	public Timestamp getCreatedon() {
//		return createdon;
//	}
//
//	public String getDevice() {
//		return device;
//	}
//
//	public Timestamp getLastlogin() {
//		return lastlogin;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "Values are " + name + " " + email;
//	}
//
//
//
//}
