package com.fc.cmapweb.web.form;

public class RestSearchFormVo {
	
	private double customerLng;
	private double customerLat;
	private int cookingTypeId;
	private String customerAddr;
	private int cityId;
	private String nowTime; // HHmm
	private int restFarAway;
	
	public double getCustomerLng() {
		return customerLng;
	}
	
	public void setCustomerLng(double customerLng) {
		this.customerLng = customerLng;
	}
	
	public double getCustomerLat() {
		return customerLat;
	}
	
	public void setCustomerLat(double customerLat) {
		this.customerLat = customerLat;
	}
	
	public int getCookingTypeId() {
		return cookingTypeId;
	}
	
	public void setCookingTypeId(int cookingTypeId) {
		this.cookingTypeId = cookingTypeId;
	}
	
	public String getCustomerAddr() {
		return customerAddr;
	}
	
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getNowTime() {
		return nowTime;
	}

	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}

	public int getRestFarAway() {
		return restFarAway;
	}

	public void setRestFarAway(int restFarAway) {
		this.restFarAway = restFarAway;
	}

}
