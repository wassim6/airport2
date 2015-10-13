package edu.esprit.ressources;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.esprit.persistance.Deal;
import edu.esprit.persistance.Feedback;
import edu.esprit.services.DealServiceLocal;
import edu.esprit.services.FeedbackServiceLocal;




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
	
	//@GET
	//@Path("/find/{startDeal}")
	//@Produces("application/json")
	//public Deal find(@PathParam("StartDeal") Date startDeal) {

	//	return myejb.findDealByDate(startDeal);

	}
	

