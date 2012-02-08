package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_TYPE")
public class UsrTypeVo implements Serializable {
	
	private static final long serialVersionUID = -3544850086972898702L;
	
	@Id
	@Column(name = "USR_TYPE_ID")
	private int usrTypeId;
	
	@Column(name = "USR_TYPE_NAME", unique = true)
	private String usrTypeName;
	
	@Column(name = "ENABLED")
	private boolean usrTypeEnabled;
	
	@Column(name = "USR_TYPE_DESC")
	private String usrTypeDesc;

	public int getUsrTypeId() {
		return usrTypeId;
	}

	public void setUsrTypeId(int usrTypeId) {
		this.usrTypeId = usrTypeId;
	}

	public String getUsrTypeName() {
		return usrTypeName;
	}

	public void setUsrTypeName(String usrTypeName) {
		this.usrTypeName = usrTypeName;
	}

	public boolean isUsrTypeEnabled() {
		return usrTypeEnabled;
	}

	public void setUsrTypeEnabled(boolean usrTypeEnabled) {
		this.usrTypeEnabled = usrTypeEnabled;
	}

	public String getUsrTypeDesc() {
		return usrTypeDesc;
	}

	public void setUsrTypeDesc(String usrTypeDesc) {
		this.usrTypeDesc = usrTypeDesc;
	}

}
