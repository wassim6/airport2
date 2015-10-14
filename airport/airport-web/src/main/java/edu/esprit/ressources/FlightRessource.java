package edu.esprit.ressources;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Flight;
import edu.esprit.persistance.Location;
import edu.esprit.services.FlightServiceLocal;


@Path("/flight")
public class FlightRessource {

	@Inject
	FlightServiceLocal myejb;
	
	@GET
	@Path("/find/{id}")
	@Produces("application/json")
     public Flight find(@PathParam("id") Integer id ) {
		return myejb.findFlightById(id);
	}
	
	@GET
	@Path("/findByNumber/{number}")
	@Produces("application/json")
     public Flight find(@PathParam("number") String number ) {
		return myejb.findFlightByNumber(number);
	}
	
	@GET
	@Path("/searchOneWay/{departLocation}/{arrivalLocation}/{dateDepart}")
	@Produces("application/json")
     public List<Flight> find(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") Date dateDepart  ) {
		
		return myejb.findFlightsOneWayByLocationAndDate(departLocationCode, arrivalLocationCode, dateDepart);
	}
	
	
	
	
	
	
	
	
/*	@POST
	@Consumes("application/json")
	public void addFlight(Flight flight){
		myejb.add(flight);
		//GwMessage gwMessage = new GwMessage();
		//gwMessage.
		
	}*/
}
