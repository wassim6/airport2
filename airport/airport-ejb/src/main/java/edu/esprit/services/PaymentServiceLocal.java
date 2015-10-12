package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.Payment;

@Local
public interface PaymentServiceLocal {
	
	public void add(Payment payment);

	public void delete(Payment payment);


	public void update(Payment payment);
	
	public Payment find(Integer id);
	


}
