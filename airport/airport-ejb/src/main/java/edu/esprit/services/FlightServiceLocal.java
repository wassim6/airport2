package edu.esprit.services;


import javax.ejb.Local;

import edu.esprit.persistance.Flight;

@Local
public interface FlightServiceLocal {
	
	
	void add(Flight flight);
	void delete(Flight flight);
	void deleteById(Integer id);
	void update(Flight flight);
	Flight findFlightById(Integer id);
	Flight findFlightByFlightNumber(String flightNumber);
/*	List<Flight> findAllAirlineCompanies();
*/	

}
