package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Client;
import edu.esprit.persistance.Employee;
import edu.esprit.persistance.Flight;

@Local
public interface EmployeeServiceLocal {

	
	//public List<Flight> findAll(Integer id);
    public void add(Employee employee);
    
    public Employee find(Integer id);

	public void update(Employee employee);

	public void delete(Employee employee);
	
	public List<Employee> findByJob(String Job);
	
	
}
