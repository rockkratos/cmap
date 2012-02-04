package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IPrivilegeDao;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends CmapBaseDao implements IPrivilegeDao {
	
	@Override
	public List<PrivilegeInfoVo> getAllPrivileges() {
		TypedQuery<PrivilegeInfoVo> tq = em.createQuery("select p from PrivilegeInfoVo p", PrivilegeInfoVo.class);
		return tq.getResultList();
	}

	@Override
	public PrivilegeInfoVo getPrivilege(String privilegeId) {
		return em.find(PrivilegeInfoVo.class, privilegeId);
	}

	@Override
	public PrivilegeInfoVo insertPrivilege(PrivilegeInfoVo privilegeInfoVo) {
		em.persist(privilegeInfoVo);
		return privilegeInfoVo;
	}

	@Override
	public PrivilegeInfoVo updatePrivilege(PrivilegeInfoVo privilegeInfoVo) {
		em.merge(privilegeInfoVo);
		return privilegeInfoVo;
	}

	@Override
	public void delPrivilege(String privilegeId) {
		em.remove(em.getReference(PrivilegeInfoVo.class, privilegeId));
	}

}
