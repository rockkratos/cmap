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
@Table(name = "REST_INFO")
public class RestInfoVo implements Serializable {
	
	private static final long serialVersionUID = 9080587500000832463L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "REST_ID")
	private String restId;
	
	@Column(name = "REST_NAME")
	private String restName;
	
	@Column(name = "REST_ADDR")
	private String restAddr;
	
	@Column(name = "REST_OPEN_TIME")
	private String restOpenTime;
	
	@Column(name = "REST_CLOSE_TIME")
	private String restCloseTime;
	
	@Column(name = "REST_LONGITUDE")
	private double restLongitude;
	
	@Column(name = "REST_LATITUDE")
	private double restLatitude;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_TRANS_TYPE_ID")
	private OrderTransTypeVo orderTransTypeVo;
	
	@ManyToOne
	@JoinColumn(name = "COOKING_TYPE_ID")
	private CookingTypeVo cookingTypeVo;
	
	@Column(name = "TAKE_AWAY_RADIUS")
	private float takeAwayRadius;
	
	@Column(name = "SENDING_AMOUNT")
	private float sendingAmount;
	
	@Column(name = "TAKE_AWAY_FEE")
	private float takeAwayFee;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@Column(name = "REST_START_TIME")
	private Date restStartTime;
	
	@Column(name = "REST_END_TIME")
	private Date restEndTime;
	
	@Column(name = "TAKE_AWAY_DESC")
	private String takeAwayDesc;
	
	@Column(name = "REST_PHONE")
	private String restPhone;
	
	@Column(name = "REST_SIGNED")
	private boolean restSigned;
	
	@ManyToOne
	@JoinColumn(name = "CITY_ID")
	private CityInfoVo cityInfoVo;
	
	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestAddr() {
		return restAddr;
	}

	public void setRestAddr(String restAddr) {
		this.restAddr = restAddr;
	}

	public String getRestOpenTime() {
		return restOpenTime;
	}

	public void setRestOpenTime(String restOpenTime) {
		this.restOpenTime = restOpenTime;
	}

	public String getRestCloseTime() {
		return restCloseTime;
	}

	public void setRestCloseTime(String restCloseTime) {
		this.restCloseTime = restCloseTime;
	}

	public double getRestLongitude() {
		return restLongitude;
	}

	public void setRestLongitude(double restLongitude) {
		this.restLongitude = restLongitude;
	}

	public double getRestLatitude() {
		return restLatitude;
	}

	public void setRestLatitude(double restLatitude) {
		this.restLatitude = restLatitude;
	}

	public OrderTransTypeVo getOrderTransTypeVo() {
		return orderTransTypeVo;
	}

	public void setOrderTransTypeVo(OrderTransTypeVo orderTransTypeVo) {
		this.orderTransTypeVo = orderTransTypeVo;
	}

	public CookingTypeVo getCookingTypeVo() {
		return cookingTypeVo;
	}

	public void setCookingTypeVo(CookingTypeVo cookingTypeVo) {
		this.cookingTypeVo = cookingTypeVo;
	}

	public float getTakeAwayRadius() {
		return takeAwayRadius;
	}

	public void setTakeAwayRadius(float takeAwayRadius) {
		this.takeAwayRadius = takeAwayRadius;
	}

	public float getSendingAmount() {
		return sendingAmount;
	}

	public void setSendingAmount(float sendingAmount) {
		this.sendingAmount = sendingAmount;
	}

	public float getTakeAwayFee() {
		return takeAwayFee;
	}

	public void setTakeAwayFee(float takeAwayFee) {
		this.takeAwayFee = takeAwayFee;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRestStartTime() {
		return restStartTime;
	}

	public void setRestStartTime(Date restStartTime) {
		this.restStartTime = restStartTime;
	}

	public Date getRestEndTime() {
		return restEndTime;
	}

	public void setRestEndTime(Date restEndTime) {
		this.restEndTime = restEndTime;
	}

	public String getTakeAwayDesc() {
		return takeAwayDesc;
	}

	public void setTakeAwayDesc(String takeAwayDesc) {
		this.takeAwayDesc = takeAwayDesc;
	}

	public String getRestPhone() {
		return restPhone;
	}

	public void setRestPhone(String restPhone) {
		this.restPhone = restPhone;
	}

	public boolean isRestSigned() {
		return restSigned;
	}

	public void setRestSigned(boolean restSigned) {
		this.restSigned = restSigned;
	}

	public CityInfoVo getCityInfoVo() {
		return cityInfoVo;
	}

	public void setCityInfoVo(CityInfoVo cityInfoVo) {
		this.cityInfoVo = cityInfoVo;
	}

}
