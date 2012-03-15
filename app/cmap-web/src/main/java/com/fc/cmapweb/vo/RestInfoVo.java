package com.fc.cmapweb.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Column(name = "REST_LNG")
	private double restLng;
	
	@Column(name = "REST_LAT")
	private double restLat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_TRANS_TYPE_ID")
	private OrderTransTypeVo orderTransTypeVo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COOKING_TYPE_ID")
	private CookingTypeVo cookingTypeVo;
	
	@Column(name = "TAKE_AWAY_RADIUS")
	private float takeAwayRadius;
	
	@Column(name = "SENDING_AMOUNT")
	private float sendingAmount;
	
	@Column(name = "TAKE_AWAY_FEE")
	private float takeAwayFee;
	
	@Column(name = "ENABLED")
	private boolean restEnabled;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	private CityInfoVo cityInfoVo;
	
	@Column(name = "PRINTER_ID")
	private String printerId;
	
	@Column(name = "PRINT_JOINT_NUM")
	private String printJointNum;
	
	@Transient
	private int logoFlag;
	
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
		this.restName = restName.trim();
	}

	public String getRestAddr() {
		return restAddr;
	}

	public void setRestAddr(String restAddr) {
		this.restAddr = restAddr.trim();
	}

	public String getRestOpenTime() {
		return restOpenTime;
	}

	public void setRestOpenTime(String restOpenTime) {
		this.restOpenTime = restOpenTime.trim();
	}

	public String getRestCloseTime() {
		return restCloseTime;
	}

	public void setRestCloseTime(String restCloseTime) {
		this.restCloseTime = restCloseTime.trim();
	}

	public double getRestLng() {
		return restLng;
	}

	public void setRestLng(double restLng) {
		this.restLng = restLng;
	}

	public double getRestLat() {
		return restLat;
	}

	public void setRestLat(double restLat) {
		this.restLat = restLat;
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

	public boolean isRestEnabled() {
		return restEnabled;
	}

	public void setRestEnabled(boolean restEnabled) {
		this.restEnabled = restEnabled;
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
		this.takeAwayDesc = takeAwayDesc.trim();
	}

	public String getRestPhone() {
		return restPhone;
	}

	public void setRestPhone(String restPhone) {
		this.restPhone = restPhone.trim();
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

	public String getPrinterId() {
		return printerId;
	}

	public void setPrinterId(String printerId) {
		this.printerId = printerId;
	}

	public String getPrintJointNum() {
		return printJointNum;
	}

	public void setPrintJointNum(String printJointNum) {
		this.printJointNum = printJointNum;
	}

	public int getLogoFlag() {
		return logoFlag;
	}

	public void setLogoFlag(int logoFlag) {
		this.logoFlag = logoFlag;
	}
	
}
