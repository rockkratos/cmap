package com.fc.cmapweb.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COOKING_TYPE")
public class CookingTypeVo implements Serializable {
	
	private static final long serialVersionUID = 7179366642461335254L;
	
	@Id
	@Column(name = "COOKING_TYPE_ID")
	private int cookingTypeId;
	
	@Column(name = "COOKING_TYPE_NAME", unique = true)
	private String cookingTypeName;
	
	@Column(name = "ENABLED")
	private boolean cookingTypeEnabled;

	public int getCookingTypeId() {
		return cookingTypeId;
	}

	public void setCookingTypeId(int cookingTypeId) {
		this.cookingTypeId = cookingTypeId;
	}

	public String getCookingTypeName() {
		return cookingTypeName;
	}

	public void setCookingTypeName(String cookingTypeName) {
		this.cookingTypeName = cookingTypeName;
	}

	public boolean isCookingTypeEnabled() {
		return cookingTypeEnabled;
	}

	public void setCookingTypeEnabled(boolean cookingTypeEnabled) {
		this.cookingTypeEnabled = cookingTypeEnabled;
	}

}
