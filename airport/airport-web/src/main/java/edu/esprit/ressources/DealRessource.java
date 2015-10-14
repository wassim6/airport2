package edu.esprit.ressources;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Deal;
import edu.esprit.services.DealServiceLocal;




@Path("/Deal")
public class DealRessource {

	
	@Inject
	DealServiceLocal myejb;	
	
	
	
	@GET
	@Path("/find")
	@Produces("application/json")
	public List<Deal> getAll()
	{	

	return myejb.findAllDeal();

	}
	
	@GET
	@Path("/find/{Deal}")
	@Produces("application/json")
	public List<Deal> find(@PathParam("Deal") Date Deal) {

		return myejb.findDealByDate(Deal);

	}
	
}
