package ua.com.emily.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.emily.dao.TransporterDao;
import ua.com.emily.domain.Transporter;

/**
 * The practical implementation of operations TransporterDao
 * 
 * @author Tanskiy R.
 */

@Repository
public class TransporterDaoImpl extends GeneralDaoImpl<Transporter, Integer> implements TransporterDao{

	public TransporterDaoImpl() {
		super(Transporter.class);
	}

	@Transactional
	public Transporter findById(int id) {
		
		return (Transporter) em.createNamedQuery("Transporter.getId").setParameter("idTransporter", id).getSingleResult();
	}
	
	
}
