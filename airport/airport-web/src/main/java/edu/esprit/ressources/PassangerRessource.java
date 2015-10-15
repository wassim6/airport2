package edu.esprit.ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Passanger;
import edu.esprit.services.PassangerServiceLocal;


@Path("/passanger")
public class PassangerRessource {
	
	@Inject
	PassangerServiceLocal myejb;
	
	@GET
	@Path("/findPassangers/{id}")
	@Produces("application/json")
     public List<Passanger> findPassangerByFlight(@PathParam("id") Integer id ) {
		return myejb.findPassangerByFlight(id);
	}
	
	
	
	
	

}
