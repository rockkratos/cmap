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
@Table(name = "CANNOT_TRANS_ADDR")
public class CannotTransAddrVo implements Serializable {
	
	private static final long serialVersionUID = 5581006684601345425L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "CANNOT_TRANS_ID")
	private String cannotTransId;
	
	@ManyToOne
	@JoinColumn(name = "ADDR_COLL_ID")
	private AddrCollVo addrCollVo;
	
	@ManyToOne
	@JoinColumn(name = "REST_ID")
	private RestInfoVo restInfoVo;

	public String getCannotTransId() {
		return cannotTransId;
	}

	public void setCannotTransId(String cannotTransId) {
		this.cannotTransId = cannotTransId;
	}

	public AddrCollVo getAddrCollVo() {
		return addrCollVo;
	}

	public void setAddrCollVo(AddrCollVo addrCollVo) {
		this.addrCollVo = addrCollVo;
	}

	public RestInfoVo getRestInfoVo() {
		return restInfoVo;
	}

	public void setRestInfoVo(RestInfoVo restInfoVo) {
		this.restInfoVo = restInfoVo;
	}

}
