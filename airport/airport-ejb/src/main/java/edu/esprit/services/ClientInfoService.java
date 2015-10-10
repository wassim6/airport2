package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.ClientInfo;

/**
 * Session Bean implementation class ClientInfoService
 */
@Stateless
@LocalBean
public class ClientInfoService implements ClientInfoServiceLocal {

	@PersistenceContext
	private EntityManager em;
    public ClientInfoService() {
       
    }
        public void add(ClientInfo client) {
    		
    		em.persist(em.merge(client));
    		
    	}
        
        public ClientInfo find(Integer id) {
    		
    		return em.find(ClientInfo.class, id);
    	}

    	public void update(ClientInfo client) {
    		
    		em.merge(client);
    		
    	}

    	public void delete(ClientInfo client) {
    		
    		em.remove(em.merge(client));
    	}

        
    	


    	
    

}
