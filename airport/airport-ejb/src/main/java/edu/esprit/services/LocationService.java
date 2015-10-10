package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Location;

/**
 * Session Bean implementation class LocationService
 */
@Stateless
@LocalBean
public class LocationService implements LocationServiceLocal {

	 @PersistenceContext
	 private EntityManager em;
    public LocationService() {
        // TODO Auto-generated constructor stub
    }
   
   

	
	public void add(Location location) {
		
		em.persist(location);
		
	}

	public Location find(Integer id) {
		
		return em.find(Location.class, id);
	}

	public void update(Location location) {
		
		em.merge(location);
		
	}

	
	
    public void delete(Integer id) {
		
		em.remove(em.find(Location.class,id));
	}


	public List<Location> findAll() {
		
		List<Location> locations = null;
		String jpql = "select l from Location l";
		TypedQuery<Location> query = em.createQuery(jpql,Location.class);
		locations = query.getResultList();
		return locations;
	}

	


}
