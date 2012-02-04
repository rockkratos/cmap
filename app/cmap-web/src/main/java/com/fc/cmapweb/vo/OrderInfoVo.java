package com.fc.cmapweb.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ORDER_INFO")
public class OrderInfoVo implements Serializable {
	
	private static final long serialVersionUID = -3745314896894532800L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ORDER_ID")
	private String orderId;
	
	@ManyToOne
	@JoinColumn(name = "USR_ID")
	private UsrInfoVo usrInfoVo;
	
	@ManyToOne
	@JoinColumn(name = "ADDR_ID")
	private DeliveryAddrVo deliveryAddrVo;
	
	@Column(name = "ORDER_TIME")
	private Date orderTime;
	
	@ManyToOne
	@JoinColumn(name = "REST_ID")
	private RestInfoVo restInfoVo;
	
	@Column(name = "REST_CFM_TIME")
	private Date restCfmTime;
	
	@Column(name = "ORDER_AMOUNT")
	private double orderAmount;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_STATUS_ID")
	private OrderStatusVo orderStatusVo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public UsrInfoVo getUsrInfoVo() {
		return usrInfoVo;
	}

	public void setUsrInfoVo(UsrInfoVo usrInfoVo) {
		this.usrInfoVo = usrInfoVo;
	}

	public DeliveryAddrVo getDeliveryAddrVo() {
		return deliveryAddrVo;
	}

	public void setDeliveryAddrVo(DeliveryAddrVo deliveryAddrVo) {
		this.deliveryAddrVo = deliveryAddrVo;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public RestInfoVo getRestInfoVo() {
		return restInfoVo;
	}

	public void setRestInfoVo(RestInfoVo restInfoVo) {
		this.restInfoVo = restInfoVo;
	}

	public Date getRestCfmTime() {
		return restCfmTime;
	}

	public void setRestCfmTime(Date restCfmTime) {
		this.restCfmTime = restCfmTime;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public OrderStatusVo getOrderStatusVo() {
		return orderStatusVo;
	}

	public void setOrderStatusVo(OrderStatusVo orderStatusVo) {
		this.orderStatusVo = orderStatusVo;
	}

}
