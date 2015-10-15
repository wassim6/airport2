package edu.esprit.ressources;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Reservation;
import edu.esprit.services.ReservationServiceLocal;



@Path("/reservation")
public class ReservationRessource {
	
	@Inject
	ReservationServiceLocal myejb;
	
	
	@PUT
	@Path("/update")
	@Produces("application/json")
	public void CancelReservation(Reservation reservation) {

		 myejb.CancelReservation(reservation);
	

	}
	
	
		
		
		@POST
		@Path("/reserver")
		@Consumes("application/json")
		public void add(Reservation reservation) {
			myejb.Reserver(reservation);
		}
		
		
		@GET
		@Path("/findById/{id}")
		@Produces("application/json")
		public Reservation find1(@PathParam("id") Integer id) {
			return myejb.find(id);

		}
		
		@GET
		@Path("/findByYear/{year}")
		@Produces("application/json")
		public List<Reservation> find2(@PathParam("year") String year) {
			return myejb.FindByYear(year);

		}
		
		@GET
		@Path("/findByPlace/{code}")
		@Produces("application/json")
		public List<Reservation> find3(@PathParam("code") String place) {
			return myejb.FindByPlace(place);

		}
		
		/*@GET
		@Path("/findByMonth/{month}")
		@Produces("application/json")
		public List<Reservation> find3(@PathParam("month") String month) {
			return myejb.FindByYear(month);

		}*/
	

}
