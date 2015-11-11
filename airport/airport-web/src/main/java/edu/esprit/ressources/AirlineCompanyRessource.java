package edu.esprit.ressources;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.esprit.persistance.AirlineCompany;
import edu.esprit.services.AirlineCompanyServiceLocal;

@Path("/airline")
public class AirlineCompanyRessource {
	@Inject
	AirlineCompanyServiceLocal myejb;

	
	@GET
	
	@Produces("application/json")
	public Response find() {

		List<AirlineCompany> airline =myejb.findAllAirlineCompanies();
		
		if (airline==null)
			return Response.status(Status.NOT_FOUND).entity("No airline company Found").build();
		else
			return Response.ok(airline).build();

	}
	
    

}
