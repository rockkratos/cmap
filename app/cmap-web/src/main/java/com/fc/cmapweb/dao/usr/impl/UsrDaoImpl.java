package com.fc.cmapweb.dao.usr.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.usr.IUsrDao;
import com.fc.cmapweb.vo.UsrInfoVo;

@Repository("usrDao")
public class UsrDaoImpl extends CmapBaseDao implements IUsrDao {

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
		
		return back;
		
	}
	
	@Override
	public UsrInfoVo insertUsr(UsrInfoVo usrInfoVo) {
		em.persist(usrInfoVo);
		return usrInfoVo;
	}
	
	@Override
	public List<String> getAllUsrRole(String loginName) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT r.roleName FROM ");
		buffer.append("RoleInfoVo r, UsrTypeRoleVo ur, UsrInfoVo u ");
		buffer.append("WHERE r.roleId = ur.roleInfoVo.roleId AND ur.usrTypeVo.usrTypeId = u.usrTypeVo.usrTypeId ");
		buffer.append("AND r.roleEnabled = TRUE ");
		buffer.append("AND u.loginName = ?");
		
		TypedQuery<String> tq = em.createQuery(buffer.toString(), String.class);
		tq.setParameter(1, loginName);
		
		return tq.getResultList();
		
	}

}
