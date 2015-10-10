package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Client;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService implements ClientServiceLocal {

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

}
