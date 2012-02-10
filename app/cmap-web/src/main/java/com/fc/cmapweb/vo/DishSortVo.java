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
@Table(name = "DISH_SORT")
public class DishSortVo implements Serializable {
	
	private static final long serialVersionUID = 5173126651716225551L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "DISH_SORT_ID")
	private String dishSortId;
	
	@Column(name = "DISH_SORT_NAME")
	private String dishSortName;
	
	@ManyToOne
	@JoinColumn(name = "REST_ID")
	private RestInfoVo restInfoVo;
	
	@Column(name = "DISH_SORT_ORDER")
	private int dishSortOrder;
	
	@Column(name = "ENABLED")
	private boolean dishSortEnabled;

	public String getDishSortId() {
		return dishSortId;
	}

	public void setDishSortId(String dishSortId) {
		this.dishSortId = dishSortId;
	}

	public String getDishSortName() {
		return dishSortName;
	}

	public void setDishSortName(String dishSortName) {
		this.dishSortName = dishSortName.trim();
	}

	public RestInfoVo getRestInfoVo() {
		return restInfoVo;
	}

	public void setRestInfoVo(RestInfoVo restInfoVo) {
		this.restInfoVo = restInfoVo;
	}

	public int getDishSortOrder() {
		return dishSortOrder;
	}

	public void setDishSortOrder(int dishSortOrder) {
		this.dishSortOrder = dishSortOrder;
	}

	public boolean isDishSortEnabled() {
		return dishSortEnabled;
	}

	public void setDishSortEnabled(boolean dishSortEnabled) {
		this.dishSortEnabled = dishSortEnabled;
	}
	
}
