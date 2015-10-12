package edu.esprit.ressources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Claim;
import edu.esprit.services.ClaimServiceLocal;


@Path("/claim")
public class ClaimRessource {
	
	
	@Inject
	ClaimServiceLocal myejb;

	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Claim claim) {
		myejb.add(claim);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Claim find(@PathParam("id") Integer id) {

		return myejb.find(id);

	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void update(Claim claim)
	{
			 myejb.update(claim);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Claim claim) {

		 myejb.delete(claim);

}
}
