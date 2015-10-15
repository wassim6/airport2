package edu.esprit.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.persistance.AirlineCompany;
import edu.esprit.persistance.Claim;
import edu.esprit.persistance.Client;
import edu.esprit.persistance.Feedback;
import edu.esprit.persistance.Flight;
import edu.esprit.persistance.Location;
import edu.esprit.persistance.Passanger;
import edu.esprit.persistance.Payment;
import edu.esprit.persistance.Plane;
import edu.esprit.persistance.Reservation;
import edu.esprit.services.AirlineCompanyServiceLocal;
import edu.esprit.services.ClaimServiceLocal;
import edu.esprit.services.ClientServiceLocal;
import edu.esprit.services.FeedbackServiceLocal;
import edu.esprit.services.FlightServiceLocal;
import edu.esprit.services.PassangerServiceLocal;
import edu.esprit.services.PaymentServiceLocal;
import edu.esprit.services.PlaneServiceLocal;
import edu.esprit.services.ReservationService;
import edu.esprit.services.ReservationServiceLocal;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	private PlaneServiceLocal planeServiceLocal;

	@EJB
	private AirlineCompanyServiceLocal airlineCompanyServiceLocal;

	@EJB
	private PassangerServiceLocal passangerServiceLocal;
	
	
	//@EJB
	//private LocationSer airlineCompanyServiceLocal;
	
	

	@EJB
	private ClientServiceLocal clientServiceLocal;

	@EJB
	private FlightServiceLocal flightServiceLocal;
	
	@EJB
	private ClaimServiceLocal claimServiceLocal;
	
	@EJB
	private FeedbackServiceLocal feedbackServiceLocal;
	
	@EJB
	private PaymentServiceLocal paymentServiceLocal;
	
	@EJB
	private ReservationServiceLocal reservationServiceLocal;
	
	
	
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
				"rima", 111111,2,"	tunisia",3);
		Client client2 = new Client("rima.aifaa@esprit.tn", "aifaa", "rimaa",
				"rima25", 222222,2,"tunisia",3);
		
		
		
		

		clientServiceLocal.add(client1);
		clientServiceLocal.add(client2);
		
		Claim claim1 = new Claim("kjffvf",client1);
    	Claim claim2= new Claim ("jdvbkfjv",client2);
    	
    	
    	claimServiceLocal.add(claim1);
    	claimServiceLocal.add(claim2);
    	
    	
    	
    	
    	Feedback feedback1 = new Feedback("hhhhhh",client1);
    	Feedback feedback2 = new Feedback("hdjdvh",client1);
    	
    	
    	feedbackServiceLocal.add(feedback1);
    	feedbackServiceLocal.add(feedback2);

		
    	
    	
    	
    			
    			
		
		Location location1 = new Location("ENH", "Tunisia",
				"Hammamet - Enfida", 4030,
				"Hammamet Enfidha International Airport", 1);
		Location location2 = new Location("TUN", "Tunisia", "Tunis", 1080,
				"Tunis-Carthage International Airport", 1);
		Location location3 = new Location("ORY", "France", "Paris", 94396,
				"Paris Orly Airport", 1);

		

		AirlineCompany airlineCompany1 = new AirlineCompany("Tunisair",
				"tunisair_logo.png");
		AirlineCompany airlineCompany2 = new AirlineCompany("Nouvelair",
				"nouvelair_logo.png");

		airlineCompanyServiceLocal.add(airlineCompany1);
		airlineCompanyServiceLocal.add(airlineCompany2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date date1 = new Date(1444829324);
		Date date2 = new Date(1449838400);
		
		Date date3 = new Date();
		Date date4 = new Date();
		try {
			date1=sdf.parse("21/12/2014 18:00");
			date2=sdf.parse("21/12/2014 20:00");
			date3=sdf.parse("24/12/2014 12:00");
			date4=sdf.parse("24/12/2014 14:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Flight flight1 = new Flight("TUKH789", location1, location2, date1,
				date2, 120, 2200, 0,300, plane1, airlineCompany1);
		Flight flight2 = new Flight("FRTN447", location2, location1, date1,
				date2, 87, 1450, 1,320, plane2, airlineCompany2);
		
		Flight flight6 = new Flight("TUKH7890", location1, location2, date1, date2, 70, 420, 1, 330, plane1, airlineCompany1);
		
		Flight flight3 = new Flight("TUFR745", location2, location3, date1, date2, 70, 420, 0, 330, plane1, airlineCompany1);
		Flight flight4 = new Flight("FRTU745", location3, location2, date3, date4, 70, 420, 0, 300, plane2, airlineCompany1);
		
		

		flightServiceLocal.add(flight1);
		flightServiceLocal.add(flight2);
		flightServiceLocal.add(flight6);
		
		flightServiceLocal.add(flight3);
		flightServiceLocal.add(flight4);
		
		Date dateNow = new Date();
		
		
		Reservation reservation = new Reservation(dateNow,"confirmé","A",flight1);
		
		reservationServiceLocal.Reserver(reservation);
		
		
		
		Payment payment = new Payment(100, "succes", reservation, client1);
		
		paymentServiceLocal.add(payment);
		
		
		try {
			date1=sdf.parse("20/03/1993 0:00");
		}catch(ParseException e) {
			e.printStackTrace();
		}
		Passanger passanger1= new Passanger("wass", "bou6", "12578654", date1, reservation);
		Passanger passanger2= new Passanger("rima", "aifa", "4875624OP", date1, reservation);
		passangerServiceLocal.addPassanger(passanger1);
		passangerServiceLocal.addPassanger(passanger2);

		
		
//		List<Flight> flights =null;
//		flights=flightServiceLocal.findFlightsOneWayByLocationAndDate(location1, location2, date1);
		
//		for(Flight f : flights){
//			System.out.println(f.toString());
//		}
	
//		System.out.println(flights.toString());
		//System.out.println(flightServiceLocal.findFlightByNumber("TUKH789"));
		
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
