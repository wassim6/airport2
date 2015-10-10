package edu.esprit.ressources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.ClientInfo;
import edu.esprit.services.ClientInfoServiceLocal;


@Path("/clientInfo")
public class ClientInfoRessource {
	
	@Inject
	ClientInfoServiceLocal myejb;
	
	
	@POST
	@Path("/add")
	@Produces("application/json")
	public void add(ClientInfo client)
	{
		myejb.add(client);
	}
	
	@GET
	@Path("/find/{id}")
	@Produces("application/json")
     public ClientInfo find(@PathParam("id") Integer id ) {
		
		return myejb.find(id);
		
	}

}
