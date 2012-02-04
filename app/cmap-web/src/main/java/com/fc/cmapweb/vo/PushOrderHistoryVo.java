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
@Table(name = "PUSH_ORDER_HISTORY")
public class PushOrderHistoryVo implements Serializable {
	
	private static final long serialVersionUID = -5496773510076581884L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "POH_ID")
	private String pohId;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private OrderInfoVo orderInfoVo;
	
	@Column(name = "PO_TIME")
	private Date poTime;

	public String getPohId() {
		return pohId;
	}

	public void setPohId(String pohId) {
		this.pohId = pohId;
	}

	public OrderInfoVo getOrderInfoVo() {
		return orderInfoVo;
	}

	public void setOrderInfoVo(OrderInfoVo orderInfoVo) {
		this.orderInfoVo = orderInfoVo;
	}

	public Date getPoTime() {
		return poTime;
	}

	public void setPoTime(Date poTime) {
		this.poTime = poTime;
	}

}
