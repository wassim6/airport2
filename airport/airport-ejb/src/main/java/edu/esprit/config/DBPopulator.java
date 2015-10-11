package edu.esprit.config;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.persistance.AirlineCompany;
import edu.esprit.persistance.Client;
import edu.esprit.persistance.Flight;
import edu.esprit.persistance.Location;
import edu.esprit.persistance.Plane;
import edu.esprit.services.AirlineCompanyServiceLocal;
import edu.esprit.services.ClientServiceLocal;
import edu.esprit.services.FlightServiceLocal;
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


	@EJB
	private ClientServiceLocal clientServiceLocal;

	@EJB
	private FlightServiceLocal flightServiceLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void createSomeEntities() {
		Plane plane1 = new Plane("Boeing 747", 955, 480, 20, 5, 0, 0);
		Plane plane2 = new Plane("Airbus A380", 945, 652, 30, 10, 0, 1);
		Plane plane3 = new Plane("Boeing 777", 950, 314, 15, 10, 1, 1);

		planeServiceLocal.add(plane1);
		planeServiceLocal.add(plane2);
		planeServiceLocal.add(plane3);
		
		Client client1 = new Client("rima@esprit.tn", "rim", "aifa", "loblob", "11111111");
		Client client2 = new Client("rima2@esprit.tn", "rim2", "aifa2", "loblob2", "22222222");

		clientServiceLocal.add(client1);
		clientServiceLocal.add(client2);
		

		Location location1 = new Location("ENH", "Tunisia",
				"Hammamet - Enfida", 4030,
				"Hammamet Enfidha International Airport", 1);
		Location location2 = new Location("TUN", "Tunisia", "Tunis", 1080,
				"Tunis-Carthage International Airport", 1);
		Location location3 = new Location("ORY", "France", "Paris", 94396,
				"Paris Orly Airport", 1);

		locationServiceLocal.add(location1);
		locationServiceLocal.add(location2);
		locationServiceLocal.add(location3);
		
		
		
		AirlineCompany airlineCompany1 = new AirlineCompany("Tunisair", "tunisair_logo.png");
		AirlineCompany airlineCompany2 = new AirlineCompany("Nouvelair", "nouvelair_logo.png");
		
		airlineCompanyServiceLocal.add(airlineCompany1);
		airlineCompanyServiceLocal.add(airlineCompany2);	
		
		Date date1 = new Date();
		Date date2 = new Date();
		
		Flight flight1 = new Flight("TUKH789", location2, location3, date1, date2, 120, 2200, 0, plane1, airlineCompany1);
		Flight flight2 = new Flight("FRTN447", location3, location2, date1, date2, 87, 1450, 1, plane2, airlineCompany2);
		
		flightServiceLocal.add(flight1);
		flightServiceLocal.add(flight2);
		
/*		flight1 = flightServiceLocal.findFlightById(2);
		System.out.println(flight1.toString());*/
		
		//flight2 = flightServiceLocal.findFlightByFlightNumber("TUKH789x");
		//System.out.println(flight2.toString());
		
	}	


}


