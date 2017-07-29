package com.wisemoney.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class UserRole implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2349611728485750355L;

	@Id
	@Column(name="UR_ID", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UserRoleIdSequence")
	@SequenceGenerator(allocationSize=1, name="UserRoleIdSequence", sequenceName="USER_ROLE_SEQ")
	private int userRoleId;
	
	@Column(name="ROLE_NAME", unique=true)
	private String roleName;
	

	public UserRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return roleName;
	}

	public void setRole(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", roleName=" + roleName + "]";
	}
	
	
	
	

}
