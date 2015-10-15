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
	
//	List<Flight> findFlightsOneWayByLocationAndDate(Location departLocation, Location locationArrival, Date dateDepart);
	
	List<Flight> findFlightsOneWayByLocationAndDate(String locationDepart, String locationArrival, String dateDepart);
	List<Flight> findFlightsOneWayByLocationAndDateOrderByPrice(String locationDepart, String locationArrival, String dateDepart, String order);
	List<Flight> findFlightsOneWayByLocationAndDateAndStopsOrderByPrice(String locationDepart, String locationArrival, String dateDepart, String order, Integer stops);
	
	
	//List<Flight> findAllF();
	

}
