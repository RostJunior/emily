package ua.com.emily.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.emily.dao.TransporterDao;
import ua.com.emily.domain.Transporter;
import ua.com.emily.service.TransporterService;
/**
 * Plain JPA implementation of {@link TransporterService}.
 * 
 * @author Tanskiy R.
 */
@Service("transporterService")
public class TransporterServiceImpl implements TransporterService{
	
	@Autowired
	private TransporterDao dao;

	
	public void createTransporter(String nameTransporter, int costOfDelivery) {
		
		Transporter trans = new Transporter(nameTransporter, costOfDelivery);
		dao.create(trans);
		
		
	}

	
	public List<Transporter> getAllTransporter() {
		
		return dao.getAll();
	}

	
	public Transporter findByIdTransporter(int idTransporter) {
		
		return dao.findById(idTransporter);
	}

	
	public void deleteTransporter(int idTransporter) {
		dao.delete(dao.findById(idTransporter));
		
	}


	public void updateTransporter(int idTransporter, String nameTransporter,
			int costOfDelivery) {
		Transporter trans = dao.findById(idTransporter);
		
		trans.setNameTransporter(nameTransporter);
		trans.setCostOfDelivery(costOfDelivery);
		
		dao.edit(trans);
	}

	
}
