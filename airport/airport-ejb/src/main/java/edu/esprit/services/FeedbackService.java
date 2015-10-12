package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	
    public List<Feedback> findAll(Integer id) {
		
		List<Feedback> feedbacks = null;
		String jpql = "select f from Feedback f where f.clientId.idClient=:x";
		TypedQuery<Feedback> query = em.createQuery(jpql,Feedback.class);
		query.setParameter("x", id);
		feedbacks = query.getResultList();
		return feedbacks;
	}

}
