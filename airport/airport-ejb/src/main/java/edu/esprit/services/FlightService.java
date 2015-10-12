package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.logging.Level;
import java.util.logging.Logger;

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

	public Flight findFlightByFlightNumber(String flightNumber) {
		Flight found = null;
		
		String jpql="select f from Flight f where f.flightNumber=:x";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("x", flightNumber);
		try{
			found  = query.getSingleResult();
		}catch(NoResultException e){
			Logger
			.getLogger(getClass().getName())
				.log(Level.WARNING, "No flight with this Flight Number");
		}
		
		return found;
	}
	

}
