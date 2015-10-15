package edu.esprit.services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		
		em.persist(claim);
		
	}
    
    public Claim find(Integer id) {
		
		return em.find(Claim.class, id);
	}

	public void update(Claim claim) {
		
		em.merge(claim);
		
	}

/*	public void delete(Claim claim,Integer id) {
		
//		System.out.println(claim);
		claim=em.find(Claim.class, claim.getIdClaim());
		System.out.println(claim.toString());
		if(claim.getClientClaim().getIdClient()== id)
		{
			System.out.println("ok !!");
			em.remove(em.merge(claim));
		}
		System.out.println("pas ok :(");
			
	}*/
	
	public void delete(Claim claim) {		
		em.remove(em.merge(claim));
	}
	
   public List<Claim> findAll(Integer id) {
		
		List<Claim> claims = null;
		String jpql = "select c from Claim c where c.clientId.idClient=:x";
		TypedQuery<Claim> query = em.createQuery(jpql,Claim.class);
		query.setParameter("x", id);
		claims = query.getResultList();
		return claims;
	}

}
