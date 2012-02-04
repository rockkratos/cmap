package com.fc.cmapweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CmapBaseDao {
	
	@PersistenceContext(unitName="jpa-unit")
	protected EntityManager em;

}
