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
import edu.esprit.persistance.Payment;
import edu.esprit.services.PaymentServiceLocal;


@Path("/payment")
public class PaymentRessource {
	
	@Inject
	PaymentServiceLocal myejb;

	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Payment payment) {
		myejb.add(payment);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Payment find(@PathParam("id") Integer id) {

		return myejb.find(id);

	}
	
	@PUT
    @Path("/update")
	@Produces("application/json")
    public void update(Payment payment)
	{
			 myejb.update(payment);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Payment payment) {

		 myejb.delete(payment);
	

}
}