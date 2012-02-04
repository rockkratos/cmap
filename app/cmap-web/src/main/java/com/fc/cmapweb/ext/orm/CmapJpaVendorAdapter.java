package com.fc.cmapweb.ext.orm;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;

import org.hibernate.cfg.Environment;
import org.hibernate.dialect.FirebirdDialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.Oracle9iDialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

public class CmapJpaVendorAdapter implements JpaVendorAdapter {

	private CmapDatabase database = CmapDatabase.DEFAULT;
	private String databasePlatform;
	private boolean generateDdl = false;
	private boolean showSql = false;
	
	private final PersistenceProvider persistenceProvider = new HibernatePersistence();
	private final JpaDialect jpaDialect = new HibernateJpaDialect();
	
	@Override
	public Map<String, ?> getJpaPropertyMap() {
		
		Map<String, Object> jpaProperties = new HashMap<String, Object>();

		if (getDatabasePlatform() != null) {
			
			jpaProperties.put(Environment.DIALECT, getDatabasePlatform());
			
		} else if (getDatabase() != null) {
			
			Class<?> databaseDialectClass = determineDatabaseDialectClass(getDatabase());
			
			if (databaseDialectClass != null) {
				jpaProperties.put(Environment.DIALECT, databaseDialectClass.getName());
			}
			
		}
		
		if (isGenerateDdl()) {
			jpaProperties.put(Environment.HBM2DDL_AUTO, "update");
		}
		
		if (isShowSql()) {
			jpaProperties.put(Environment.SHOW_SQL, "true");
		}
		
		return jpaProperties;
		
	}
	
	protected Class<?> determineDatabaseDialectClass(CmapDatabase database) {
		
		switch (database) {
			
			case FIREBIRD: return FirebirdDialect.class;
			case MYSQL: return MySQLDialect.class;
			case ORACLE: return Oracle9iDialect.class;
			case POSTGRESQL: return PostgreSQLDialect.class;
			
			default: return null;
			
		}
		
	}
	
	@Override
	public JpaDialect getJpaDialect() {
		return this.jpaDialect;
	}

	@Override
	public String getPersistenceProviderRootPackage() {
		return "org.hibernate";
	}
	
	@Override
	public PersistenceProvider getPersistenceProvider() {
		return this.persistenceProvider;
	}
	
	@Override
	public Class<? extends EntityManagerFactory> getEntityManagerFactoryInterface() {
		return EntityManagerFactory.class;
	}
	
	@Override
	public Class<? extends EntityManager> getEntityManagerInterface() {
		return EntityManager.class;
	}
	
	@Override
	public void postProcessEntityManagerFactory(EntityManagerFactory emf) {}
	
	public CmapDatabase getDatabase() {
		return database;
	}

	public void setDatabase(CmapDatabase database) {
		this.database = database;
	}
	
	public void setDatabasePlatform(String databasePlatform) {
		this.databasePlatform = databasePlatform;
	}
	
	protected String getDatabasePlatform() {
		return this.databasePlatform;
	}
	
	public void setGenerateDdl(boolean generateDdl) {
		this.generateDdl = generateDdl;
	}
	
	protected boolean isGenerateDdl() {
		return this.generateDdl;
	}
	
	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}
	
	protected boolean isShowSql() {
		return this.showSql;
	}

}
