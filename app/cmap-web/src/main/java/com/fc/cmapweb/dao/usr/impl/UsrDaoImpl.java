package com.fc.cmapweb.dao.usr.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.usr.IUsrDao;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrInfoVo;

@Repository("usrDao")
public class UsrDaoImpl extends CmapBaseDao implements IUsrDao {
	
	@Override
	public UsrInfoVo updatePwd(String usrId, String newPwd) {
		
		UsrInfoVo usr = getUsrInfoByUsrId(usrId);
		usr.setLoginPwd(StrUtil.getSHAEncryptData(newPwd));
		
		return usr;
		
	}
	
	@Override
	public UsrInfoVo updateUsr(UsrInfoVo usrInfoVo) {
		
		if (usrInfoVo.getLoginPwd().length() != 64) {
			String encryptPwd = StrUtil.getSHAEncryptData(usrInfoVo.getLoginPwd());
			usrInfoVo.setLoginPwd(encryptPwd);
		}
		
		em.merge(usrInfoVo);
		
		return usrInfoVo;
		
	}
	
	@Override
	public UsrInfoVo getUsrInfoByUsrId(String usrId) {
		return em.find(UsrInfoVo.class, usrId);
	}
	
	@Override
	public void delUsr(String usrId) {
		em.remove(em.getReference(UsrInfoVo.class, usrId));
	}
	
	@Override
	public boolean switchEnableDisable(String usrId) {
		
		UsrInfoVo tmp = getUsrInfoByUsrId(usrId);
		tmp.setUsrEnabled(tmp.isUsrEnabled() == true ? false : true);
		
		return tmp.isUsrEnabled();
		
	}
	
	@Override
	public List<UsrInfoVo> getUsr(boolean isCustomer, Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT u FROM UsrInfoVo u ");
		
		String queryCondition = ParamUtil.getQueryConditionJPQL(queryParams, "u");
		
		if (queryCondition.length() > 0) {
			
			buffer.append(queryCondition);
			
			if (isCustomer) {
				buffer.append(" AND u.usrTypeVo.usrTypeId = " + CmapValues.USR_TYPE_CUSTOMER);
			} else {
				buffer.append(" AND u.usrTypeVo.usrTypeId <> " + CmapValues.USR_TYPE_CUSTOMER);
			}
			
		} else {
			
			if (isCustomer) {
				buffer.append(" WHERE u.usrTypeVo.usrTypeId = " + CmapValues.USR_TYPE_CUSTOMER);
			} else {
				buffer.append(" WHERE u.usrTypeVo.usrTypeId <> " + CmapValues.USR_TYPE_CUSTOMER);
			}
			
		}
		
		buffer.append(" ORDER BY u.loginName");
		
		return em.createQuery(buffer.toString(), UsrInfoVo.class)
				 .setFirstResult(currentPage * pageSize)
				 .setMaxResults(pageSize)
				 .getResultList();
		
	}
	
	@Override
	public int getUsrCount(boolean isCustomer, Map<String, Object> queryParams) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT COUNT(u) FROM UsrInfoVo u ");
		
		String queryCondition = ParamUtil.getQueryConditionJPQL(queryParams, "u");
		
		if (queryCondition.length() > 0) {
			
			buffer.append(queryCondition);
			if (isCustomer) {
				buffer.append(" AND u.usrTypeVo.usrTypeId = " + CmapValues.USR_TYPE_CUSTOMER);
			} else {
				buffer.append(" AND u.usrTypeVo.usrTypeId <> " + CmapValues.USR_TYPE_CUSTOMER);
			}
			
		} else {
			
			if (isCustomer) {
				buffer.append(" WHERE u.usrTypeVo.usrTypeId = " + CmapValues.USR_TYPE_CUSTOMER);
			} else {
				buffer.append(" WHERE u.usrTypeVo.usrTypeId <> " + CmapValues.USR_TYPE_CUSTOMER);
			}
			
		}
		
		Query rowCountQuery = em.createQuery(buffer.toString());
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}
	
	@Override
	public UsrInfoVo getUsrInfo(String loginName) {
		
		UsrInfoVo back = null;
		String jpql = "SELECT u FROM UsrInfoVo u WHERE u.loginName = ?";
		
		TypedQuery<UsrInfoVo> tq = em.createQuery(jpql, UsrInfoVo.class);
		tq.setParameter(1, loginName);
		
		try {
			back = tq.getSingleResult();
		} catch (NoResultException e) {
			back = null;
		} catch (NonUniqueResultException e) {
			back = tq.getResultList().get(0);
		}
		
		//Load lazy attr
		back.getUsrTypeVo().getUsrTypeId();
		
		return back;
		
	}
	
	@Override
	public UsrInfoVo insertUsr(UsrInfoVo usrInfoVo) {
		
		String encryptPwd = StrUtil.getSHAEncryptData(usrInfoVo.getLoginPwd());
		usrInfoVo.setLoginPwd(encryptPwd);
		
		em.persist(usrInfoVo);
		return usrInfoVo;
		
	}
	
	@Override
	public List<String> getAllUsrRole(String loginName) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT ur.roleInfoVo.roleName ");
		buffer.append("FROM UsrTypeRoleVo ur, UsrInfoVo u ");
		buffer.append("WHERE ur.usrTypeVo.usrTypeId = u.usrTypeVo.usrTypeId ");
		buffer.append("AND ur.roleInfoVo.roleEnabled = TRUE AND u.loginName = ?");
		
		TypedQuery<String> tq = em.createQuery(buffer.toString(), String.class);
		tq.setParameter(1, loginName);
		
		return tq.getResultList();
		
	}

}
