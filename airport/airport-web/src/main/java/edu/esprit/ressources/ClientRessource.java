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

import edu.esprit.persistance.Client;
import edu.esprit.services.ClientServiceLocal;

@Path("/client")
public class ClientRessource {
	@Inject
	ClientServiceLocal myejb;

	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Client client) {
		myejb.add(client);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Client find(@PathParam("id") Integer id) {

		return myejb.find(id);

	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void update(Client client)
	{
			 myejb.update(client);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Client client) {

		 myejb.delete(client);

	}
	
	

}
