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
@Table(name = "USR_INFO")
public class UsrInfoVo implements Serializable {

	private static final long serialVersionUID = 8247916780241029714L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "USR_ID")
	private String usrId;
	
	@Column(name = "LOGIN_NAME", unique = true)
	private String loginName;
	
	@Column(name = "LOGIN_PWD")
	private String loginPwd;
	
	@Column(name = "NICK_NAME")
	private String nickName;
	
	@Column(name = "REAL_NAME")
	private String realName;
	
	@Column(name = "USR_CELL", unique = true)
	private String usrCell;
	
	@Column(name = "USR_EMAIL", unique = true)
	private String usrEmail;
	
	@Column(name = "REG_TIME")
	private Date regTime;
	
	@Column(name = "BAD_PWD_COUNT")
	private int badPwdCount;
	
	@Column(name = "ENABLED")
	private boolean usrEnabled;
	
	@ManyToOne
	@JoinColumn(name = "USR_TYPE_ID")
	private UsrTypeVo usrTypeVo;
	
	@Column(name = "LAST_LOGIN_TIME")
	private Date lastLoginTime;
	
	@Column(name = "LAST_LOGIN_IP")
	private String lastLoginIp;

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUsrCell() {
		return usrCell;
	}

	public void setUsrCell(String usrCell) {
		this.usrCell = usrCell;
	}

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public int getBadPwdCount() {
		return badPwdCount;
	}

	public void setBadPwdCount(int badPwdCount) {
		this.badPwdCount = badPwdCount;
	}

	public boolean isUsrEnabled() {
		return usrEnabled;
	}

	public void setUsrEnabled(boolean usrEnabled) {
		this.usrEnabled = usrEnabled;
	}

	public UsrTypeVo getUsrTypeVo() {
		return usrTypeVo;
	}

	public void setUsrTypeVo(UsrTypeVo usrTypeVo) {
		this.usrTypeVo = usrTypeVo;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

}
