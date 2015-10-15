package edu.esprit.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.AirlineCompany;

/**
 * Session Bean implementation class AirlineCompanyService
 */
@Stateless
@LocalBean
public class AirlineCompanyService implements AirlineCompanyServiceLocal,AirlineCompanyServiceRemote {

	@PersistenceContext
	private EntityManager em;
	
    public AirlineCompanyService() {
    }

	@Override
	public void add(AirlineCompany airlineCompany) {
		em.persist(airlineCompany);
	}

	@Override
	public void delete(AirlineCompany airlineCompany) {
		em.remove(em.merge(airlineCompany));
	}

	@Override
	public void deleteById(Integer id) {
		em.remove(em.find(AirlineCompany.class, id));		
	}

	@Override
	public void update(AirlineCompany airlineCompany) {
		em.merge(airlineCompany);
	}

	@Override
	public AirlineCompany findAirlineCompanyById(Integer id) {
		return em.find(AirlineCompany.class, id);
		
	}

	@Override
	public List<AirlineCompany> findAllAirlineCompanies() {
		return em
				.createQuery("select a from AirlineCompany a", AirlineCompany.class)
				.getResultList();
	}

	@Override
	public AirlineCompany findAirlineCompanyByName(String name) {
		AirlineCompany found = null;
		String jpql = "select a from AirlineCompany a where a.name=:x";
		TypedQuery<AirlineCompany> query = em.createQuery(jpql, AirlineCompany.class);
		query.setParameter("x", name);
		try{
			found = query.getSingleResult();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no AirlineCompany found");
		}
		return found;
	}

}
