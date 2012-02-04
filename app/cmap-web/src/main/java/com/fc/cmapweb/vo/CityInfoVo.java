package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITY_INFO")
public class CityInfoVo implements Serializable {
	
	private static final long serialVersionUID = 18340790607479954L;
	
	@Id
	@Column(name = "CITY_ID")
	private int cityId;
	
	@Column(name = "CITY_NAME", unique = true)
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name = "PROVINCE_ID")
	private ProvinceInfoVo provinceInfoVo;
	
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public ProvinceInfoVo getProvinceInfoVo() {
		return provinceInfoVo;
	}

	public void setProvinceInfoVo(ProvinceInfoVo provinceInfoVo) {
		this.provinceInfoVo = provinceInfoVo;
	}

}
