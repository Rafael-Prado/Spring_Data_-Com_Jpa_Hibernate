package br.com.prado.jpaHibernate.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private EntityManagerFactory factory;
	
	private static JPAUtil instance;
	
	private JPAUtil(){
		this.factory = Persistence.createEntityManagerFactory("JpaHibernate");
	}
	
	public static synchronized JPAUtil getInstance(){
		if(instance == null){
			instance = new JPAUtil();
		}
		return instance;
	}
	
	public EntityManager getEntityManeger(){
		return factory.createEntityManager();
	}
}

