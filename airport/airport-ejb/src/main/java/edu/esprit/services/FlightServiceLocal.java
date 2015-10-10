package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Flight;

@Local
public interface FlightServiceLocal {
	
	
	void add(Flight flight);
	void delete(Flight flight);
	void deleteById(Integer id);
	void update(Flight flight);
/*	Flight findAirlineCompanyById(Integer id);
	Flight findAirlineCompanyByName(String name);
	List<Flight> findAllAirlineCompanies();
*/	

}
