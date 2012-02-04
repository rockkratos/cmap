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
@Table(name = "ADDR_COLL")
public class AddrCollVo implements Serializable {
	
	private static final long serialVersionUID = -1598369490756356466L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ADDR_COLL_ID")
	private String addrCollId;
	
	@Column(name = "ADDR_NAME")
	private String addrName;
	
	@Column(name = "SEPC_ADDR")
	private String sepcAddr;
	
	@Column(name = "ADDR_LONGITUDE")
	private double addrLongitude;
	
	@Column(name = "ADDR_LATITUDE")
	private double addrLatitude;
	
	@ManyToOne
	@JoinColumn(name = "CITY_ID")
	private CityInfoVo cityInfoVo;
	
	@ManyToOne
	@JoinColumn(name = "ADDR_TYPE_ID")
	private AddrTypeVo addrTypeVo;

	public String getAddrCollId() {
		return addrCollId;
	}

	public void setAddrCollId(String addrCollId) {
		this.addrCollId = addrCollId;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getSepcAddr() {
		return sepcAddr;
	}

	public void setSepcAddr(String sepcAddr) {
		this.sepcAddr = sepcAddr;
	}

	public double getAddrLongitude() {
		return addrLongitude;
	}

	public void setAddrLongitude(double addrLongitude) {
		this.addrLongitude = addrLongitude;
	}

	public double getAddrLatitude() {
		return addrLatitude;
	}

	public void setAddrLatitude(double addrLatitude) {
		this.addrLatitude = addrLatitude;
	}

	public CityInfoVo getCityInfoVo() {
		return cityInfoVo;
	}

	public void setCityInfoVo(CityInfoVo cityInfoVo) {
		this.cityInfoVo = cityInfoVo;
	}

	public AddrTypeVo getAddrTypeVo() {
		return addrTypeVo;
	}

	public void setAddrTypeVo(AddrTypeVo addrTypeVo) {
		this.addrTypeVo = addrTypeVo;
	}
	
}
