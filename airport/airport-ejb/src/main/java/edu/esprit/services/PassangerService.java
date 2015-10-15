package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
