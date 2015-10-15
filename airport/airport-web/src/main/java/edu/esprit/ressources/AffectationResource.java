package edu.esprit.ressources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Affectation;
import edu.esprit.services.AffectationServiceLocal;



@Path("/affectation")
public class AffectationResource {

	
	@Inject
	AffectationServiceLocal myejb;
	
	
	
	@GET
	@Path("/findAll/{id}")
	@Produces("application/json")
	public List<Affectation> getAll(@PathParam("id") Integer id) {
		
		return myejb.findAll(id);
		
	}
	
	
	
}





