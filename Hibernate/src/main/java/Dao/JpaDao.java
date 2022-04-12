package Dao;

import Util.HibernateUtil;

import java.util.List;
import Exception.DaoException;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class JpaDao<E> {
	protected EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public E create(E entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.flush();
			entityManager.refresh(entity);
			entityManager.getTransaction().commit();	
		} catch (RuntimeException e) {
			throw new DaoException(entity.getClass() + ".create() error : " + entity.toString());
		}
		return entity;
	}
	
	public E find(Class<E> type, Object id) {
		try {
			E entity = entityManager.find(type, id);
			if (entity != null) {
				entityManager.refresh(entity);			
			}
			
			return entity;
		} catch (RuntimeException e) {
			throw new DaoException(type.getName() + ".find() error : " + id);
		}
	}
	
	public E update(E entity) {
		try {
			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;	
		} catch (Exception e) {
			throw new DaoException(entity.getClass() + ".update() error : " + entity.toString());
		}
	}
	
	public void delete(Class<E> type, Object id) {
		try {
			entityManager.getTransaction().begin();
			Object reference = entityManager.getReference(type, id);
			entityManager.remove(reference);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(type.getName() + ".delete() error : " + id);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findWithNamedQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return query.getResultList();
	}
	
	public long countWithNamedQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
}
