package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ROLE_PRIVILEGE")
public class RolePrivilegeVo implements Serializable {
	
	private static final long serialVersionUID = 1979453803288134003L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ROLE_PRIVILEGE_ID")
	private String rolePrivilegeId;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleInfoVo roleInfoVo;
	
	@ManyToOne
	@JoinColumn(name = "PRIVILEGE_ID")
	private PrivilegeInfoVo privilegeInfoVo;

	public String getRolePrivilegeId() {
		return rolePrivilegeId;
	}

	public void setRolePrivilegeId(String rolePrivilegeId) {
		this.rolePrivilegeId = rolePrivilegeId;
	}

	public RoleInfoVo getRoleInfoVo() {
		return roleInfoVo;
	}

	public void setRoleInfoVo(RoleInfoVo roleInfoVo) {
		this.roleInfoVo = roleInfoVo;
	}

	public PrivilegeInfoVo getPrivilegeInfoVo() {
		return privilegeInfoVo;
	}

	public void setPrivilegeInfoVo(PrivilegeInfoVo privilegeInfoVo) {
		this.privilegeInfoVo = privilegeInfoVo;
	}

}
