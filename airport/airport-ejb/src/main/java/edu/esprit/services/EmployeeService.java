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
	public List<Employee> findByEmail(String email) {
		email="%"+email+"%";
			return 
					 em.createQuery("select e from Employee e where e.email like :x",Employee.class)
					 .setParameter("x",email)
					 .getResultList();
		}
	
}
