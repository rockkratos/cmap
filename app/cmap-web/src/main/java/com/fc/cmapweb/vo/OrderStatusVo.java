package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatusVo implements Serializable {
	
	private static final long serialVersionUID = -7052261128515887791L;
	
	@Id
	@Column(name = "ORDER_STATUS_ID")
	private int orderStatusId;
	
	@Column(name = "ORDER_STATUS_TYPE", unique = true)
	private String orderStatusType;

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusType() {
		return orderStatusType;
	}

	public void setOrderStatusType(String orderStatusType) {
		this.orderStatusType = orderStatusType;
	}

}
