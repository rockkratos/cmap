package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HTTP_METHOD_TYPE")
public class HttpMethodTypeVo implements Serializable {
	
	private static final long serialVersionUID = -5340264212987524150L;
	
	@Id
	@Column(name = "METHOD_TYPE_ID")
	private int methodTypeId;
	
	@Column(name = "METHOD_TYPE", unique = true)
	private String methodType;
	
	@Column(name = "METHOD_DESC")
	private String methodDesc;

	public int getMethodTypeId() {
		return methodTypeId;
	}

	public void setMethodTypeId(int methodTypeId) {
		this.methodTypeId = methodTypeId;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getMethodDesc() {
		return methodDesc;
	}

	public void setMethodDesc(String methodDesc) {
		this.methodDesc = methodDesc;
	}
	
}
