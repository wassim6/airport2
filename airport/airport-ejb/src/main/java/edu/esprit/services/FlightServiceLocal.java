package edu.esprit.services;


import java.util.ArrayList;
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
	
	
	List<Flight> findFlightsOneWayByLocationAndDate(String locationDepart, String locationArrival, String dateDepart);
	List<Flight> findFlightsOneWayByLocationAndDateAndStops(String locationDepart, String locationArrival, String dateDepart, Integer stops);
	List<Flight> findFlightsOneWayFullParam(String locationDepart, String locationArrival, String dateDepart, Integer stops, Integer minPrice, Integer maxPrice);

	
	List<Flight> findFlightsOneWayByLocationAndDateOrdered(String locationDepart, String locationArrival, String dateDepart, String orderBy, String order);
	List<Flight> findFlightsOneWayByLocationAndDateAndStopsOrdered(String locationDepart, String locationArrival, String dateDepart, Integer stops, String orderBy, String order);
	List<Flight> findFlightsOneWayFullParamOrdered(String locationDepart, String locationArrival, String dateDepart, Integer stops, Integer minPrice, Integer maxPrice, String orderBy, String order);
	
	
	ArrayList<Flight> findFlightsRoundTripByLocationAndDate(String locationDepart, String locationArrival, String dateDepart, String dateReturn);
	
	

}
