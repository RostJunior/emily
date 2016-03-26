package ua.com.emily.service;

import java.util.List;

import ua.com.emily.domain.Transporter;


public interface TransporterService {
	
	void createTransporter(String nameTransporter, int costOfDelivery);
	
	List<Transporter> getAllTransporter();
	
	Transporter findByIdTransporter(int idTransporter);
	
	void deleteTransporter(int idTransporter);
	
	void updateTransporter(int idTransporter, String nameTransporter, int costOfDelivery);
	

}
