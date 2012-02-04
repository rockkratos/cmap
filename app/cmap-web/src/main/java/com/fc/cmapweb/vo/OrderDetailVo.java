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
@Table(name = "ORDER_DETAIL")
public class OrderDetailVo implements Serializable {
	
	private static final long serialVersionUID = -402506207088354548L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ORDER_DETAIL_ID")
	private String orderDetailId;
	
	@ManyToOne
	@JoinColumn(name = "DISH_ID")
	private DishInfoVo dishInfoVo;
	
	@Column(name = "DISH_QUANTITY")
	private int dishQuantity;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private OrderInfoVo orderInfoVo;

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public DishInfoVo getDishInfoVo() {
		return dishInfoVo;
	}

	public void setDishInfoVo(DishInfoVo dishInfoVo) {
		this.dishInfoVo = dishInfoVo;
	}

	public int getDishQuantity() {
		return dishQuantity;
	}

	public void setDishQuantity(int dishQuantity) {
		this.dishQuantity = dishQuantity;
	}

	public OrderInfoVo getOrderInfoVo() {
		return orderInfoVo;
	}

	public void setOrderInfoVo(OrderInfoVo orderInfoVo) {
		this.orderInfoVo = orderInfoVo;
	}
	
}
