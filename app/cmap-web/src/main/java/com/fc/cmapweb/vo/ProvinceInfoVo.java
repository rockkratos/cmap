package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCE_INFO")
public class ProvinceInfoVo implements Serializable {
	
	private static final long serialVersionUID = 8099108469088510481L;
	
	@Id
	@Column(name = "PROVINCE_ID")
	private int provinceId;
	
	@Column(name = "PROVINCE_NAME", unique = true)
	private String provinceName;
	
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
