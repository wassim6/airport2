package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.AirlineCompany;

/**
 * Session Bean implementation class AirlineCompanyService
 */
@Stateless
@LocalBean
public class AirlineCompanyService implements AirlineCompanyServiceLocal {

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
		return em.find(AirlineCompany.class, name);
	}

}
