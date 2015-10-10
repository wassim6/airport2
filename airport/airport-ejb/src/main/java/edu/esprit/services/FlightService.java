package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Flight flight) {
		em.persist(flight);
	}

}
