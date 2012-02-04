package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TRANS_TYPE")
public class OrderTransTypeVo implements Serializable {
	
	private static final long serialVersionUID = -1749335276831495652L;
	
	@Id
	@Column(name = "ORDER_TRANS_TYPE_ID")
	private int orderTransTypeId;
	
	@Column(name = "ORDER_TRANS_TYPE_CODE", unique = true)
	private String orderTransTypeCode;
	
	@Column(name = "ORDER_TRANS_TYPE_NAME")
	private String orderTransTypeName;

	public int getOrderTransTypeId() {
		return orderTransTypeId;
	}

	public void setOrderTransTypeId(int orderTransTypeId) {
		this.orderTransTypeId = orderTransTypeId;
	}

	public String getOrderTransTypeCode() {
		return orderTransTypeCode;
	}

	public void setOrderTransTypeCode(String orderTransTypeCode) {
		this.orderTransTypeCode = orderTransTypeCode;
	}

	public String getOrderTransTypeName() {
		return orderTransTypeName;
	}

	public void setOrderTransTypeName(String orderTransTypeName) {
		this.orderTransTypeName = orderTransTypeName;
	}

}
