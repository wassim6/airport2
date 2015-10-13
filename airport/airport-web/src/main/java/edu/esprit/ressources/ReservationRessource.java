package edu.esprit.ressources;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
	

}
