package edu.esprit.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Flight;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService implements FlightServiceLocal {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public FlightService() {
    }

	public void add(Flight flight) {
		em.persist(flight);
	}

	public void delete(Flight flight) {
		em.remove(em.merge(flight));
	}

	public void deleteById(Integer id) {
		em.remove(em.find(Flight.class, id));
	}

	public void update(Flight flight) {
		em.merge(flight);
	}

	public Flight findFlightById(Integer id) {
		return em.find(Flight.class, id);
	}

	public Flight findFlightByNumber(String number) {
		Flight found = null;
		String jpql = "select f from Flight f where f.flightNumber=:x";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("x", number);
		try{
			found = query.getSingleResult();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with flightNumber="+number);
		}
		return found;
	}
	
	
	
	

}
