package edu.esprit.config;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.persistance.AirlineCompany;
import edu.esprit.persistance.Client;
import edu.esprit.persistance.ClientInfo;
import edu.esprit.persistance.Flight;
import edu.esprit.persistance.Plane;
import edu.esprit.services.AirlineCompanyServiceLocal;
import edu.esprit.services.ClientInfoServiceLocal;
import edu.esprit.services.ClientServiceLocal;
import edu.esprit.services.FlightServiceLocal;
import edu.esprit.services.GwMessage;
import edu.esprit.services.PlaneServiceLocal;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	private PlaneServiceLocal planeServiceLocal;

	@EJB
	private AirlineCompanyServiceLocal airlineCompanyServiceLocal;

	@EJB
	private ClientInfoServiceLocal clientInfoServiceLocal;

	@EJB
	private ClientServiceLocal clientServiceLocal;

	@EJB
	private FlightServiceLocal flightServiceLocal;

	@EJB
	private GwMessage gwMessage;
	
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

		Client client1 = new Client("rim.aifa@esprit.tn", "aifa", "rim",
				"rima", 111111);
		Client client2 = new Client("rima.aifaa@esprit.tn", "aifaa", "rimaa",
				"rima25", 222222);

		clientServiceLocal.add(client1);
		clientServiceLocal.add(client2);

		/*ClientInfo clientInfo1 = new ClientInfo(2, "tunisie", 3, client1);
		ClientInfo clientInfo2 = new ClientInfo(2, "france", 3, client2);

		clientInfoServiceLocal.add(clientInfo1);
		clientInfoServiceLocal.add(clientInfo2);
*/
		
/*		Location location1 = new Location("ENH", "Tunisia",
				"Hammamet - Enfida", 4030,
				"Hammamet Enfidha International Airport", 1);
		Location location2 = new Location("TUN", "Tunisia", "Tunis", 1080,
				"Tunis-Carthage International Airport", 1);
		Location location3 = new Location("ORY", "France", "Paris", 94396,
				"Paris Orly Airport", 1);*/


		AirlineCompany airlineCompany1 = new AirlineCompany("Tunisair",
				"tunisair_logo.png");
		AirlineCompany airlineCompany2 = new AirlineCompany("Nouvelair",
				"nouvelair_logo.png");

		airlineCompanyServiceLocal.add(airlineCompany1);
		airlineCompanyServiceLocal.add(airlineCompany2);
		Date date1 = new Date(1444838400);
		Date date2 = new Date(2015, 10, 28);

		Flight flight1 = new Flight("TUKH789", "Tunisie, Tunis, Tunis-Carthage International Airport", "France, Paris, Paris Orly Airport", date1,
				date2, 120, 2200, 0,300, plane1, airlineCompany1);
		Flight flight2 = new Flight("FRTN447", "France, Paris, Paris Orly Airport", "Tunisie, Tunis, Tunis-Carthage International Airport", date1,
				date2, 87, 1450, 1,320, plane2, airlineCompany2);

		flightServiceLocal.add(flight1);
		flightServiceLocal.add(flight2);
		
		
//		System.out.println(flightServiceLocal.findFlightByNumber("TUKH789"));
		
		//gwMessage = new GwMessage();
		//gwMessage.sendEmail("wassim.boussetta@esprit.tn", "falloussaf@gmail.com", "test", "ttttttttttest");
		
		//System.out.println(gwMessage.toString());
		//System.out.println("ccccccccccccc");
		

/*		flight1.setFlightMiles(20);
		flightServiceLocal.update(flight1);

		flight2.setFlightNumber("XXXX");
		flightServiceLocal.update(flight2);
*/		


	}



}
