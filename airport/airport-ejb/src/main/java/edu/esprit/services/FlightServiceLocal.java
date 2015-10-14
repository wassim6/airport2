package edu.esprit.services;


import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Flight;
import edu.esprit.persistance.Location;

@Local
public interface FlightServiceLocal {
	
	
	void add(Flight flight);
	void delete(Flight flight);
	void deleteById(Integer id);
	void update(Flight flight);
	Flight findFlightById(Integer id);
	Flight findFlightByNumber(String name);
	
	List<Flight> findFlightsOneWayByLocationAndDate(Location departLocation, Location locationArrival, Date dateDepart);
	List<Flight> findFlightsOneWayByLocationAndDate(String departLocation, String locationArrival, Date dateDepart);
	
	//List<Flight> findAllF();
	

}
