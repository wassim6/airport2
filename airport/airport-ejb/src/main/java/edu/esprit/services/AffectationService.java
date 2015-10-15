package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Affectation;
import edu.esprit.persistance.Flight;

/**
 * Session Bean implementation class AffectationService
 */
@Stateless
@LocalBean
public class AffectationService implements AffectationServiceLocal {

	
	@PersistenceContext
	private EntityManager em;
	
    public AffectationService() {
    	
    	
    }

	@Override
	public List<Affectation> findAll(Integer id) {
		List<Affectation> Affectations = null;
		String jpql = "select a from Affectation a  where a.employee.idEmployee=:x";
		TypedQuery<Affectation> query = em.createQuery(jpql,Affectation.class);
		query.setParameter("x", id);
		Affectations = query.getResultList();
		return Affectations;
	}

}
