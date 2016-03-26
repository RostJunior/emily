package ua.com.emily.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.GeneralDao;

/**
 * The practical implementation of CRUD operations with object
 * 
 * @author Tanskiy R.
 */

@Repository
public abstract class GeneralDaoImpl<C, N extends Number> implements GeneralDao<C, N>{

private Class<C> entityClass;
	
	public GeneralDaoImpl(Class<C> entityClass){
		this.entityClass = entityClass;
	}
	
	
	@PersistenceContext(unitName="Primary")
	EntityManager em;
	
	@Transactional
	public void create(C entity) {
		em.persist(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<C> getAll() {
		
		return em.createQuery("from " + entityClass.getSimpleName()).getResultList();
	}

	

	@Transactional
	public void delete(C entity) {
		em.remove(em.merge(entity));
		
	}

	@Transactional
	public void edit(C entity) {
		em.merge(entity);
		
	}

		
	
	
}
