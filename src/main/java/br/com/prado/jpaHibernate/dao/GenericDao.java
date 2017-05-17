package br.com.prado.jpaHibernate.dao;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.prado.jpaHibernate.Util.JPAUtil;

public abstract class GenericDao<T extends Serializable>{

	private Class<T> aClass;
	
	public GenericDao(Class<T> aClass) {
		this.aClass = aClass;
	}
	
	protected EntityManager getEntityManager() {
		return JPAUtil.getInstance().getEntityManeger();		
	}
	
	public Long count(){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("SELECT COUNT(c) FROM " + aClass.getSimpleName() + "c");
		
		Long entity =  (Long) query.getSingleResult();			
		manager.getTransaction().commit();
		manager.close();
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public T FindOne(String jpql, Object... params){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		//Consulta jpql
		Query query = manager.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}		
		T entity = (T) query.getSingleResult();			
		manager.getTransaction().commit();
		manager.close();
		return entity;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> Find(String jpql, Object... params){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		//Consulta jpql
		Query query = manager.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}		
		List<T> entities = query.getResultList();			
		manager.getTransaction().commit();
		manager.close();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("From" + aClass.getSimpleName());
		List<T> entities = query.getResultList();		
		manager.getTransaction().commit();
		manager.close();		
		return entities;
	}
		
	public T findBydId(Long id){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		T entity =(T)manager.find(aClass, id);		
		manager.getTransaction().commit();
		manager.close();
		
		return entity;
	}
	
	
	public void save(T entity){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	public void update(T entity){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Long id){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.getReference(aClass, id));
		manager.getTransaction().commit();
		manager.close();
	}
}
