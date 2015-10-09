package edu.esprit.config;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.persistance.Plane;
import edu.esprit.services.PlaneServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	
	@EJB
	private PlaneServiceLocal planeServiceLocal;
	
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void createSomePlane(){
		Plane plane1 = new Plane("TestPlane1", 490, 120, 20, 5, 0, 1);
		Plane plane2 = new Plane("TestPlane2", 530, 200, 25, 10, 1, 1);
		
		planeServiceLocal.add(plane1);
		planeServiceLocal.add(plane2);
	}
	
	

}
