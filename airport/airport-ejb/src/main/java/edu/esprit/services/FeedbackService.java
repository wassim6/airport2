package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Feedback;

/**
 * Session Bean implementation class FeedbackService
 */
@Stateless
@LocalBean
public class FeedbackService implements FeedbackServiceLocal {

	@PersistenceContext
	private EntityManager em;
    public FeedbackService() {
        // TODO Auto-generated constructor stub
    }
    
 public void add(Feedback feedback) {
		
		em.persist(em.merge(feedback));
		
	}
    
    public Feedback find(Integer id) {
		
		return em.find(Feedback.class, id);
	}

	public void update(Feedback feedback) {
		
		em.merge(feedback);
		
	}

	public void delete(Feedback feedback) {
		
		em.remove(em.merge(feedback));
	}

}
