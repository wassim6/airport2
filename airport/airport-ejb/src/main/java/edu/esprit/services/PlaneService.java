package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.esprit.persistance.Plane;

/**
 * Session Bean implementation class PlaneService
 */
@Stateless
@LocalBean
public class PlaneService implements PlaneServiceLocal {

    /**
     * Default constructor. 
     */
    public PlaneService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Plane plane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Plane plane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Plane plane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Plane findPlaneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plane> findAllPlane() {
		// TODO Auto-generated method stub
		return null;
	}

}
