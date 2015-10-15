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
	@Path("/searchOneWay/{departLocation}/{arrivalLocation}/{dateDepart}/{stops}")
	@Produces("application/json")
     public List<Flight> findOneWayWithStops(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart, 
		 				@PathParam("stops") Integer stops ) {
		
		return myejb.findFlightsOneWayByLocationAndDateAndStops(departLocationCode, arrivalLocationCode, dateDepart, stops);
	}
	
	@GET
	@Path("/searchOneWay/{departLocation}/{arrivalLocation}/{dateDepart}/{stops}/{minPrice}/{maxPrice}")
	@Produces("application/json")
     public List<Flight> findOneWayFullParam(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart, 
		 				@PathParam("stops") Integer stops,
		 				@PathParam("minPrice") Integer minPrice,
		 				@PathParam("maxPrice") Integer maxPrice) {
		
		return myejb.findFlightsOneWayFullParam(departLocationCode, arrivalLocationCode, dateDepart, stops, minPrice, maxPrice);
	}
	

	
	@GET
	@Path("/searchOneWay2/{departLocation}/{arrivalLocation}/{dateDepart}/{orderBy}/{order}")
	@Produces("application/json")
     public List<Flight> findOneWayOrdered(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart,
		 				@PathParam("orderBy") String orderBy,
		 				@PathParam("order") String order) {
		
		return myejb.findFlightsOneWayByLocationAndDateOrdered(departLocationCode, arrivalLocationCode, dateDepart, orderBy, order);
	}
	
	@GET
	@Path("/searchOneWay2/{departLocation}/{arrivalLocation}/{dateDepart}/{stops}/{orderBy}/{order}")
	@Produces("application/json")
     public List<Flight> findOneWayWithStopsOrdered(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart,
		 				@PathParam("orderBy") String orderBy,
		 				@PathParam("order") String order,
		 				@PathParam("stops") Integer stops) {
		
		return myejb.findFlightsOneWayByLocationAndDateAndStopsOrdered(departLocationCode, arrivalLocationCode, dateDepart,stops, orderBy, order);
	}
	
	@GET
	@Path("/searchOneWay2/{departLocation}/{arrivalLocation}/{dateDepart}/{stops}/{minPrice}/{maxPrice}/{orderBy}/{order}")
	@Produces("application/json")
     public List<Flight> findOneWayFullParamOrdered(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart,
		 				@PathParam("orderBy") String orderBy,
		 				@PathParam("order") String order,
		 				@PathParam("stops") Integer stops,
		 				@PathParam("minPrice") Integer minPrice,
		 				@PathParam("maxPrice") Integer maxPrice) {
		
		return myejb.findFlightsOneWayFullParamOrdered(departLocationCode, arrivalLocationCode, dateDepart,stops, minPrice, maxPrice, orderBy, order);
	}
	
	
	
	
	
	
	
	
	@GET
	@Path("/searchRoundTrip/{departLocation}/{arrivalLocation}/{dateDepart}/{dateReturn}")
	@Produces("application/json")
     public List<Flight> findRoundTrip(@PathParam("departLocation") String departLocationCode,
    		 			@PathParam("arrivalLocation") String arrivalLocationCode,
		 				@PathParam("dateDepart") String dateDepart, 
		 				@PathParam("dateReturn") String dateReturn  ) {
		
		return myejb.findFlightsRoundTripByLocationAndDate(departLocationCode, arrivalLocationCode, dateDepart, dateReturn);
	}
	
	

}
