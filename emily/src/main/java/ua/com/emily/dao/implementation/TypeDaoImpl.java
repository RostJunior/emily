package ua.com.emily.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.TypeDao;
import ua.com.emily.domain.Type;

/**
 * The practical implementation of operations TypeDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class TypeDaoImpl extends GeneralDaoImpl<Type, Integer> implements TypeDao{
	
	public TypeDaoImpl(){
		super(Type.class);
	}

	@Transactional
	public Type findById(int id) {
		
		return (Type) em.createNamedQuery("Type.getId").setParameter("idType", id).getSingleResult();
	}
	

}
