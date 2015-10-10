package edu.esprit.config;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.persistance.AirlineCompany;
import edu.esprit.persistance.Location;
import edu.esprit.persistance.Plane;
import edu.esprit.services.AirlineCompanyServiceLocal;
import edu.esprit.services.LocationServiceLocal;
import edu.esprit.services.PlaneServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	
	@EJB
	private PlaneServiceLocal planeServiceLocal;
	
	@EJB
	private LocationServiceLocal locationServiceLocal;
	
	@EJB
	private AirlineCompanyServiceLocal airlineCompanyServiceLocal;
	
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void createSomePlane(){
		Plane plane1 = new Plane("Boeing 747", 955, 480, 20, 5, 0, 0);
		Plane plane2 = new Plane("Airbus A380", 945, 652, 30, 10, 0, 1);
		Plane plane3 = new Plane("Boeing 777", 950, 314, 15, 10, 1,1);
		
		planeServiceLocal.add(plane1);
		planeServiceLocal.add(plane2);
		planeServiceLocal.add(plane3);
	}
	
	@PostConstruct
	public void createSomeLocation(){
		Location location1 = new Location("ENH","Tunisia","Hammamet - Enfida",4030 ,"Hammamet Enfidha International Airport",1);
		Location location2 = new Location("TUN","Tunisia","Tunis", 1080 ,"Tunis-Carthage International Airport", 1);		
		Location location3 = new Location("ORY","France", "Paris",94396 ,"Paris Orly Airport",1);		

		locationServiceLocal.add(location1);
		locationServiceLocal.add(location2);
		locationServiceLocal.add(location3);
	}
	
	@PostConstruct
	public void createSomeAirlineCompant(){
		AirlineCompany airlineCompany1 = new AirlineCompany("Tunisair", "tunisair_logo.png");
		AirlineCompany airlineCompany2 = new AirlineCompany("Nouvelair", "nouvelair_logo.png");
		
		airlineCompanyServiceLocal.add(airlineCompany1);
		airlineCompanyServiceLocal.add(airlineCompany2);
	}
	

}
