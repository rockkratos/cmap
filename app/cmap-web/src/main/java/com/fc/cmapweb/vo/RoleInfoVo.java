package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ROLE_INFO")
public class RoleInfoVo implements Serializable {
	
	private static final long serialVersionUID = -4300857003696415749L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ROLE_ID")
	private String roleId;
	
	@Column(name = "ROLE_NAME", unique = true)
	private String roleName;
	
	@Column(name = "ENABLED")
	private boolean roleEnabled;
	
	@Column(name = "ROLE_DESC")
	private String roleDesc;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public boolean isRoleEnabled() {
		return roleEnabled;
	}

	public void setRoleEnabled(boolean roleEnabled) {
		this.roleEnabled = roleEnabled;
	}

}
