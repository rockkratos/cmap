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
@Table(name = "PRMT_INFO")
public class PrmtInfoVo implements Serializable {
	
	private static final long serialVersionUID = -2282315512690435564L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PRMT_INFO_ID")
	private String prmtInfoId;
	
	@Column(name = "PRMT_INFO_DESC")
	private String prmtInfoDesc;
	
	@ManyToOne
	@JoinColumn(name = "REST_ID")
	private RestInfoVo restInfoVo;
	
	@Column(name = "PRMT_START_TIME")
	private Date prmtStartTime;
	
	@Column(name = "PRMT_END_TIME")
	private Date prmtEndTime;
	
	@Column(name = "ENABLED")
	private boolean prmtEnabled;

	public String getPrmtInfoId() {
		return prmtInfoId;
	}

	public void setPrmtInfoId(String prmtInfoId) {
		this.prmtInfoId = prmtInfoId;
	}

	public String getPrmtInfoDesc() {
		return prmtInfoDesc;
	}

	public void setPrmtInfoDesc(String prmtInfoDesc) {
		this.prmtInfoDesc = prmtInfoDesc;
	}

	public RestInfoVo getRestInfoVo() {
		return restInfoVo;
	}

	public void setRestInfoVo(RestInfoVo restInfoVo) {
		this.restInfoVo = restInfoVo;
	}

	public Date getPrmtStartTime() {
		return prmtStartTime;
	}

	public void setPrmtStartTime(Date prmtStartTime) {
		this.prmtStartTime = prmtStartTime;
	}

	public Date getPrmtEndTime() {
		return prmtEndTime;
	}

	public void setPrmtEndTime(Date prmtEndTime) {
		this.prmtEndTime = prmtEndTime;
	}

	public boolean isPrmtEnabled() {
		return prmtEnabled;
	}

	public void setPrmtEnabled(boolean prmtEnabled) {
		this.prmtEnabled = prmtEnabled;
	}
	
}
