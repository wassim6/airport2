package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Employee;
import edu.esprit.persistance.Flight;

/**
 * Session Bean implementation class EmployeeService
 */
@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceLocal {

	@PersistenceContext
	private EntityManager em;
    public EmployeeService() {
      
    }
	/*	
    @Override
	public List<Flight> findAll(Integer id) {
		 
			
    	List<Flight> Flights = null;
				String jpql = "select f from Flight f where f.idEmployee.idEmployee=:x";
				TypedQuery<Flight> query = em.createQuery(jpql,Flight.class);
				query.setParameter("x", id);
				Flights = query.getResultList();
				return Flights;
			}
		*/	

	@Override
	public void add(Employee employee) {
		em.persist(em.merge(employee));
		
	}



	@Override
	public void update(Employee employee) {
		em.merge(employee);}

	@Override
	public void delete(Employee employee) {
		em.remove(em.merge(employee));
		}

	@Override
	public Employee find(Integer id) {			
				return em.find(Employee.class, id);
			}

	@Override
	public List<Employee> findByJob(String Job) {
		Job="%"+Job+"%";
		return 
				 em.createQuery("select e from Employee e where e.job like :x",Employee.class)
				 .setParameter("x",Job)
				 .getResultList();
	
	}
	
}
