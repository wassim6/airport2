package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Claim;

/**
 * Session Bean implementation class ClaimService
 */
@Stateless
@LocalBean
public class ClaimService implements ClaimServiceLocal {

	@PersistenceContext
	private EntityManager em;
    public ClaimService() {
    	
    	
    }
    
 public void add(Claim claim) {
		
		em.persist(em.merge(claim));
		
	}
    
    public Claim find(Integer id) {
		
		return em.find(Claim.class, id);
	}

	public void update(Claim claim) {
		
		em.merge(claim);
		
	}

	public void delete(Claim claim) {
		
		em.remove(em.merge(claim));
	}

}
