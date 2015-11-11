package edu.esprit.ressources;


import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import edu.esprit.persistance.Client;
import edu.esprit.services.ClientServiceLocal;

@Path("/client")
public class ClientRessource {
	@Inject
	ClientServiceLocal myejb;

	@POST
//	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Client client) {
		
		Client c = new Client(client.getEmail(), client.getFirstName(), client.getLastName(), client.getPassword());
		
		if(myejb.add(c))
		{
			
			return Response.ok(c).build();
		}
		return  Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response find(@PathParam("id") Integer id) {
		
		
		Client client = myejb.find(id);
		if(client == null)
		{
			
			return Response.status(Status.NOT_FOUND).build();
		}
		return  Response.ok(client).build();
			

	}
	
	@GET
	@Path("/findClient/{email}/{password}")
	@Produces("application/json")
	public Response existC(@PathParam("email") String email, @PathParam("password") String password ) {

		Client client =myejb.existC(email, password);
		
		if (client==null)
			return Response.status(Status.NOT_FOUND).entity("User Not Found").build();
		else
			return Response.ok(client).build();

	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putMethod(Client client){
    	//Client c = new Client(client.getEmail(), client.getFirstName(), client.getLastName(),client.getMilesParcoured(),client.getNumberTrips(), client.getPassword(),client.getPhone());
    	Client c =myejb.find(client.getIdClient());
    	client.setCreateTime(c.getCreateTime());
    	myejb.update(client);
    	return Response.status(Status.OK).entity(client).build();
    }
	
/*	@PUT
    @Path("/update")
	@Consumes("application/json")
    public Response update(Client client)
	{
		//Client c = new Client(client.getEmail(), client.getFirstName(), client.getLastName(),client.getMilesParcoured(),client.getNumberTrips(), client.getPassword(),client.getPhone());
			 
			 if(myejb.update(client))
				{
					
					return Response.ok(client).build();
				}
				return  Response.status(Status.NOT_FOUND).build();
	}*/
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response delete(@PathParam("id") Integer id) {

		 if(myejb.delete(id))
			{
				
				return Response.ok(id).build();
			}
			return  Response.status(Status.NOT_FOUND).build();
		 

	}
	
	

}
