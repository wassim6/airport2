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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.esprit.persistance.Client;
import edu.esprit.persistance.Feedback;
import edu.esprit.services.FeedbackServiceLocal;

@Path("/feedback")
public class FeedbackRessource {
	
	
	@Inject
	FeedbackServiceLocal myejb;

	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Feedback feedback) {
		myejb.add(feedback);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Feedback find(@PathParam("id") Integer id) {

		return myejb.find(id);

	}
	
	@PUT
    @Path("/update")
	@Produces("application/json")
    public void update(Feedback feedback)
	{
			 myejb.update(feedback);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Feedback feedback) {

		 myejb.delete(feedback);
		 

}
	
	@GET
	@Path("/findAll/{id}")
	@Produces("application/json")
	public Response getAll(@PathParam("id") Integer id) {
		
		List<Feedback> feedbacks = myejb.findAll(id);
		if (feedbacks==null)
			return Response.status(Status.NOT_FOUND).entity("no feedbacks").build();
		else
			return Response.ok(feedbacks).build();
		
	}
}
