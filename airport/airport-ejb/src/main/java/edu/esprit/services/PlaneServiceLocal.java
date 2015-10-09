package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Plane;

@Local
public interface PlaneServiceLocal {

	void create(Plane plane);
	void delete(Plane plane);
	void deleteById(Integer id);
	void update(Plane plane);
	Plane findPlaneById(Integer id);
	List<Plane> findAllPlane();
	
}
