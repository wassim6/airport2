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

import edu.esprit.persistance.Employee;
import edu.esprit.services.EmployeeServiceLocal;




@Path("/employee")
public class EmployeeRessource {
	@Inject
EmployeeServiceLocal myejb;

	@POST
	@Path("/add")
	@Consumes("application/json")
	public void add(Employee employee) {
		myejb.add(employee);
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Employee find(@PathParam("id") Integer id) {

		return myejb.find(id);

	}
	
	@PUT
    @Path("/update")
	@Consumes("application/json")
    public void update(Employee employee)
	{
			 myejb.update(employee);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public void delete(Employee employee) {

		 myejb.delete(employee);

	}
	/*@GET
	@Path("/findAll/{id}")
	@Produces("application/json")
	public List<Flight> getAll(@PathParam("id") Integer id) {
		
		return myejb.findAll(id);
		
	}
	
*/
	
	@GET
	@Path("/findByEmail/{email}")
	@Produces("application/json")
	public List<Employee> findByEmail(@PathParam("email") String email) {

		return myejb.findByEmail(email);

	}
	
	
	
}
