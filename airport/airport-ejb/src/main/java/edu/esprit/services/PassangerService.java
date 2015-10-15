package edu.esprit.services;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Deal;
import edu.esprit.persistance.Passanger;

/**
 * Session Bean implementation class PassangerService
 */
@Stateless
@LocalBean
public class PassangerService implements PassangerServiceLocal {


	@PersistenceContext
	private EntityManager em;
	
    public PassangerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addPassanger(Passanger passanger) {
		em.persist(passanger);
	}
	
	public List<Passanger> findPassangerByFlight(Integer id) {
		
		List<Passanger> passangers = null;
		String jpql = " select p from Passanger p where p.reservations.flight.idFlight=:id ";
		TypedQuery<Passanger> query = em.createQuery(jpql,Passanger.class);
		query.setParameter("id",id);
		passangers = query.getResultList();
		return passangers;
	}

}
