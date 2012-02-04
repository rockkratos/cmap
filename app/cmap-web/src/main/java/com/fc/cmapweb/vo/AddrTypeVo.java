package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDR_TYPE")
public class AddrTypeVo implements Serializable {
	
	private static final long serialVersionUID = 2953961756073103149L;
	
	@Id
	@Column(name = "ADDR_TYPE_ID")
	private int addrTypeId;
	
	@Column(name = "ADDR_TYPE_NAME")
	private String addrTypeName;

	public int getAddrTypeId() {
		return addrTypeId;
	}

	public void setAddrTypeId(int addrTypeId) {
		this.addrTypeId = addrTypeId;
	}

	public String getAddrTypeName() {
		return addrTypeName;
	}

	public void setAddrTypeName(String addrTypeName) {
		this.addrTypeName = addrTypeName;
	}

}
