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
@Table(name = "DISH_INFO")
public class DishInfoVo implements Serializable {
	
	private static final long serialVersionUID = 6124799525355057888L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "DISH_ID")
	private String dishId;
	
	@Column(name = "DISH_NAME")
	private String dishName;
	
	@Column(name = "DISH_PRICE")
	private float dishPrice;
	
	@Column(name = "DISH_PRMT_PRICE")
	private float dishPrmtPrice;
	
	@ManyToOne
	@JoinColumn(name = "DISH_SORT_ID")
	private DishSortVo dishSortVo;
	
	@Column(name = "ENABLED")
	private boolean dishEnabled;
	
	@Column(name = "DISH_PRMT")
	private boolean dishPrmt;
	
	@Column(name = "DISH_DESC")
	private String dishDesc;

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public float getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(float dishPrice) {
		this.dishPrice = dishPrice;
	}

	public float getDishPrmtPrice() {
		return dishPrmtPrice;
	}

	public void setDishPrmtPrice(float dishPrmtPrice) {
		this.dishPrmtPrice = dishPrmtPrice;
	}

	public DishSortVo getDishSortVo() {
		return dishSortVo;
	}

	public void setDishSortVo(DishSortVo dishSortVo) {
		this.dishSortVo = dishSortVo;
	}

	public boolean isDishEnabled() {
		return dishEnabled;
	}

	public void setDishEnabled(boolean dishEnabled) {
		this.dishEnabled = dishEnabled;
	}

	public boolean isDishPrmt() {
		return dishPrmt;
	}

	public void setDishPrmt(boolean dishPrmt) {
		this.dishPrmt = dishPrmt;
	}

	public String getDishDesc() {
		return dishDesc;
	}

	public void setDishDesc(String dishDesc) {
		this.dishDesc = dishDesc;
	}

}
