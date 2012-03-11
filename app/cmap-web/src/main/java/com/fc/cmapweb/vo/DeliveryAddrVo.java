package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DELIVERY_ADDR")
public class DeliveryAddrVo implements Serializable {
	
	private static final long serialVersionUID = 908137563403694417L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ADDR_ID")
	private String addrId;
	
	@Column(name = "SPEC_ADDR")
	private String specAddr;
	
	@Column(name = "PHONE_NBR")
	private String phoneNbr;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USR_ID")
	private UsrInfoVo usrInfoVo;
	
	@Column(name = "IS_DEFAULT")
	private boolean defaultAddrFlag;

	public String getAddrId() {
		return addrId;
	}

	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	public String getSpecAddr() {
		return specAddr;
	}

	public void setSpecAddr(String specAddr) {
		this.specAddr = specAddr.trim();
	}

	public String getPhoneNbr() {
		return phoneNbr;
	}

	public void setPhoneNbr(String phoneNbr) {
		this.phoneNbr = phoneNbr.trim();
	}

	public UsrInfoVo getUsrInfoVo() {
		return usrInfoVo;
	}

	public void setUsrInfoVo(UsrInfoVo usrInfoVo) {
		this.usrInfoVo = usrInfoVo;
	}

	public boolean isDefaultAddrFlag() {
		return defaultAddrFlag;
	}

	public void setDefaultAddrFlag(boolean defaultAddrFlag) {
		this.defaultAddrFlag = defaultAddrFlag;
	}

}
