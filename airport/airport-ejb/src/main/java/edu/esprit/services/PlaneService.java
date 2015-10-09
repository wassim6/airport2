package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Plane;

/**
 * Session Bean implementation class PlaneService
 */
@Stateless
@LocalBean
public class PlaneService implements PlaneServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PlaneService() {
    }

	public void add(Plane plane) {
		em.persist(plane);
	}

	public void delete(Plane plane) {
		em.remove(em.merge(plane));
	}

	public void deleteById(Integer id) {
		em.remove(em.find(Plane.class, id));
	}

	public void update(Plane plane) {
		
	}

	public Plane findPlaneById(Integer id) {
		return em.find(Plane.class, id);
	}

	public List<Plane> findAllPlane() {
		return em
				.createQuery("select p from Plane p", Plane.class)
				.getResultList();
	}

}
