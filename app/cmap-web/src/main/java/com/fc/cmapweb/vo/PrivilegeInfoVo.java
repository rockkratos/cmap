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
@Table(name = "PRIVILEGE_INFO")
public class PrivilegeInfoVo implements Serializable {
	
	private static final long serialVersionUID = -843668965224977334L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PRIVILEGE_ID")
	private String privilegeId;
	
	@Column(name = "PRIVILEGE_NAME", unique = true)
	private String privilegeName;
	
	@Column(name = "RES_PATH")
	private String resPath;
	
	@ManyToOne
	@JoinColumn(name = "METHOD_TYPE_ID")
	private HttpMethodTypeVo httpMethodTypeVo;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@Column(name = "PRIVILEGE_DESC")
	private String privilegeDesc;

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getResPath() {
		return resPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	public HttpMethodTypeVo getHttpMethodTypeVo() {
		return httpMethodTypeVo;
	}

	public void setHttpMethodTypeVo(HttpMethodTypeVo httpMethodTypeVo) {
		this.httpMethodTypeVo = httpMethodTypeVo;
	}

	public String getPrivilegeDesc() {
		return privilegeDesc;
	}

	public void setPrivilegeDesc(String privilegeDesc) {
		this.privilegeDesc = privilegeDesc;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
