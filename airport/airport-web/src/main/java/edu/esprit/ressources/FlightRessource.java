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
     public List<Flight> findOneWay(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart  ) {
		
		return myejb.findFlightsOneWayByLocationAndDate(departLocationCode, arrivalLocationCode, dateDepart);
	}
	
	@GET
	@Path("/searchOneWay/{departLocation}/{arrivalLocation}/{dateDepart}/{order}")
	@Produces("application/json")
     public List<Flight> findOneWayByPrice(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart,
		 				@PathParam("order") String order) {
		
		return myejb.findFlightsOneWayByLocationAndDateOrderByPrice(departLocationCode, arrivalLocationCode, dateDepart, order);
	}
	
	@GET
	@Path("/searchOneWay/{departLocation}/{arrivalLocation}/{dateDepart}/{order}/{stops}")
	@Produces("application/json")
     public List<Flight> findOneWayByStopsAndPrice(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart,
		 				@PathParam("order") String order,
		 				@PathParam("stops") Integer stops) {
		
		return myejb.findFlightsOneWayByLocationAndDateAndStopsOrderByPrice(departLocationCode, arrivalLocationCode, dateDepart, order, stops);
	}
	
	
	

}
