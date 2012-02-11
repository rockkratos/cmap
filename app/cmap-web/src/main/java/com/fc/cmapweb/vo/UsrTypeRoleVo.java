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
@Table(name = "USR_TYPE_ROLE")
public class UsrTypeRoleVo implements Serializable {
	
	private static final long serialVersionUID = 3585732970128614248L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "USR_ROLE_ID")
	private String usrRoleId;
	
	@ManyToOne
	@JoinColumn(name = "USR_TYPE_ID")	
	private UsrTypeVo usrTypeVo;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleInfoVo roleInfoVo;

	public String getUsrRoleId() {
		return usrRoleId;
	}

	public void setUsrRoleId(String usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	public UsrTypeVo getUsrTypeVo() {
		return usrTypeVo;
	}

	public void setUsrTypeVo(UsrTypeVo usrTypeVo) {
		this.usrTypeVo = usrTypeVo;
	}

	public RoleInfoVo getRoleInfoVo() {
		return roleInfoVo;
	}

	public void setRoleInfoVo(RoleInfoVo roleInfoVo) {
		this.roleInfoVo = roleInfoVo;
	}
	
}
