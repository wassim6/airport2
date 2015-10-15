package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Payment;

/**
 * Session Bean implementation class PaymentService
 */
@Stateless
@LocalBean
public class PaymentService implements PaymentServiceLocal {

   
	
	@PersistenceContext
	private EntityManager em;
    public PaymentService() {
    }
    

    	public void add(Payment payment) {
    		em.persist(payment);
    	}

    	public void delete(Payment payment) {
    		em.remove(em.merge(payment));
    	}


    	public void update(Payment payment) {
    		em.merge(payment);
    	}
    	
    	public Payment find(Integer id) {
    		
    		return em.find(Payment.class, id);
    	}
    	
    

}
