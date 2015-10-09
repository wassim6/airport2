package edu.esprit.ressources;


import javax.inject.Inject;
import javax.ws.rs.Path;

import edu.esprit.services.ReservationServiceLocal;



@Path("/reservation")
public class ReservationRessource {
	
	@Inject
	ReservationServiceLocal myejb;
	
	
	

}
