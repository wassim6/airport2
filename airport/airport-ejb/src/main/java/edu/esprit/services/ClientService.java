package edu.esprit.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Client;
import edu.esprit.services.ClientServiceLocal;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService implements ClientServiceLocal{

	@PersistenceContext
	private EntityManager em;
    public ClientService() {
        
    	
    
    }

    
    public void add(Client client) {
		
		em.persist(client);
    	
		
	}
    
    public Client find(Integer id) {
		
		return em.find(Client.class, id);
	}

	public void update(Client client) {
		
		em.merge(client);
		
	}

	public void delete(Client client) {
		
		em.remove(em.merge(client));
	}
	
	public Client existC(String email,String password) {
		
		Client found = null;
		String jpql = "select c from Client c where c.email=:x AND c.password=:p";
		TypedQuery<Client> query = em.createQuery(jpql, Client.class);
		query.setParameter("x", email);
		query.setParameter("p", password);
		try{
			found = query.getSingleResult();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no client with email="+email);
		}
		return found;
	}


	
	

}
