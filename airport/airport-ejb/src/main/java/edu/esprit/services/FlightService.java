package edu.esprit.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import edu.esprit.persistance.Flight;
import edu.esprit.persistance.Location;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService implements FlightServiceLocal {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public FlightService() {
    }

	public void add(Flight flight) {
		em.persist(flight);
	}

	public void delete(Flight flight) {
		em.remove(em.merge(flight));
	}

	public void deleteById(Integer id) {
		em.remove(em.find(Flight.class, id));
	}

	public void update(Flight flight) {
		em.merge(flight);
	}

	public Flight findFlightById(Integer id) {
		return em.find(Flight.class, id);
	}

	public Flight findFlightByNumber(String number) {
		Flight found = null;
		String jpql = "select f from Flight f where f.flightNumber=:x";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("x", number);
		try{
			found = query.getSingleResult();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with flightNumber="+number);
		}
		return found;
	}

	
	
	@Override
	public List<Flight> findFlightsOneWayByLocationAndDate(
			String locationDepart, String locationArrival, String dateDepart) {
		
		String p1=dateDepart+"-00:00:00";
		String p2=dateDepart+"-23:59:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1=sdf.parse(p1);
			date2=sdf.parse(p2);
		} catch (ParseException e) {
			e.printStackTrace();
		}		

		
		List<Flight> flights = null;
		String jpql = "select f from Flight f where "
				+ "f.departLocation.airportCode=:locationDepart And f.arrivalLocation.airportCode=:locationArrival "
				+ "AND f.departDate>=:dateDepart AND f.departDate<=:dateDepart2";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("locationDepart", locationDepart);
		query.setParameter("locationArrival", locationArrival);
		query.setParameter("dateDepart", date1);
		query.setParameter("dateDepart2", date2);
		try{
			flights = query.getResultList();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with this parameter");
		}
		return flights;

	}

	@Override
	public List<Flight> findFlightsOneWayByLocationAndDateOrdered(
			String locationDepart, String locationArrival, String dateDepart,
			String orderBy, String order) {
		String p1=dateDepart+"-00:00:00";
		String p2=dateDepart+"-23:59:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1=sdf.parse(p1);
			date2=sdf.parse(p2);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		
		if(order.equals("ASC") || order.equals("DESC") || order.equals("asc") || order.equals("desc") ){	
		}
		else{
			order="ASC";
		}
		
		if(orderBy.equals("price") || orderBy.equals("flightDuration") ||  orderBy.equals("numberStops")){
		}
		else{
			orderBy="price";
		}
		
		List<Flight> flights = null;
		String jpql = "select f from Flight f where "
				+ "f.departLocation.airportCode=:locationDepart And f.arrivalLocation.airportCode=:locationArrival "
				+ "AND f.departDate>=:dateDepart AND f.departDate<=:dateDepart2 ORDER BY f."+orderBy+" "+order;
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("locationDepart", locationDepart);
		query.setParameter("locationArrival", locationArrival);
		query.setParameter("dateDepart", date1);
		query.setParameter("dateDepart2", date2);
		try{
			flights = query.getResultList();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with this parameter");
		}
		return flights;
	}
	
	@Override
	public List<Flight> findFlightsOneWayByLocationAndDateAndStops(
			String locationDepart, String locationArrival, String dateDepart,
			Integer stops) {
		String p1=dateDepart+"-00:00:00";
		String p2=dateDepart+"-23:59:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1=sdf.parse(p1);
			date2=sdf.parse(p2);
		} catch (ParseException e) {
			e.printStackTrace();
		}		

		
		List<Flight> flights = null;
		String jpql = "select f from Flight f where "
				+ "f.departLocation.airportCode=:locationDepart And f.arrivalLocation.airportCode=:locationArrival "
				+ "AND f.departDate>=:dateDepart AND f.departDate<=:dateDepart2 AND f.numberStops=:stops";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("locationDepart", locationDepart);
		query.setParameter("locationArrival", locationArrival);
		query.setParameter("dateDepart", date1);
		query.setParameter("dateDepart2", date2);
		query.setParameter("stops", stops);
		try{
			flights = query.getResultList();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with this parameter");
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightsOneWayByLocationAndDateAndStopsOrdered(
			String locationDepart, String locationArrival, String dateDepart,
			Integer stops, String orderBy, String order) {
		String p1=dateDepart+"-00:00:00";
		String p2=dateDepart+"-23:59:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1=sdf.parse(p1);
			date2=sdf.parse(p2);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		
		if(order.equals("ASC") || order.equals("DESC") || order.equals("asc") || order.equals("desc") ){	
		}
		else{
			order="ASC";
		}
		
		if(orderBy.equals("price") || orderBy.equals("flightDuration") ||  orderBy.equals("numberStops")){
		}
		else{
			orderBy="price";
		}
		
		List<Flight> flights = null;
		String jpql = "select f from Flight f where "
				+ "f.departLocation.airportCode=:locationDepart And f.arrivalLocation.airportCode=:locationArrival "
				+ "AND f.departDate>=:dateDepart AND f.departDate<=:dateDepart2 AND f.numberStops=:stops ORDER BY f."+orderBy+" "+order;
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("locationDepart", locationDepart);
		query.setParameter("locationArrival", locationArrival);
		query.setParameter("dateDepart", date1);
		query.setParameter("dateDepart2", date2);
		query.setParameter("stops", stops);
		try{
			flights = query.getResultList();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with this parameter");
		}
		return flights;
	}
	
	@Override
	public List<Flight> findFlightsOneWayFullParam(String locationDepart,
			String locationArrival, String dateDepart, Integer stops,
			Integer minPrice, Integer maxPrice) {
		String p1=dateDepart+"-00:00:00";
		String p2=dateDepart+"-23:59:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1=sdf.parse(p1);
			date2=sdf.parse(p2);
		} catch (ParseException e) {
			e.printStackTrace();
		}		

		
		List<Flight> flights = null;
		String jpql = "select f from Flight f where "
				+ "f.departLocation.airportCode=:locationDepart And f.arrivalLocation.airportCode=:locationArrival "
				+ "AND f.departDate>=:dateDepart AND f.departDate<=:dateDepart2 AND f.numberStops=:stops AND f.price>=:minPrice AND f.price<=:maxPrice";
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("locationDepart", locationDepart);
		query.setParameter("locationArrival", locationArrival);
		query.setParameter("dateDepart", date1);
		query.setParameter("dateDepart2", date2);
		query.setParameter("stops", stops);
		query.setParameter("minPrice", minPrice);
		query.setParameter("maxPrice", maxPrice);
		try{
			flights = query.getResultList();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with this parameter");
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightsOneWayFullParamOrdered(
			String locationDepart, String locationArrival, String dateDepart,
			Integer stops, Integer minPrice, Integer maxPrice, String orderBy,
			String order) {
		String p1=dateDepart+"-00:00:00";
		String p2=dateDepart+"-23:59:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
		Date date1 = new Date();
		Date date2 = new Date();
		try {
			date1=sdf.parse(p1);
			date2=sdf.parse(p2);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		
		if(order.equals("ASC") || order.equals("DESC") || order.equals("asc") || order.equals("desc") ){	
		}
		else{
			order="ASC";
		}
		
		if(orderBy.equals("price") || orderBy.equals("flightDuration") ||  orderBy.equals("numberStops")){
		}
		else{
			orderBy="price";
		}
		
		List<Flight> flights = null;
		String jpql = "select f from Flight f where "
				+ "f.departLocation.airportCode=:locationDepart And f.arrivalLocation.airportCode=:locationArrival "
				+ "AND f.departDate>=:dateDepart AND f.departDate<=:dateDepart2 AND f.numberStops=:stops AND f.price>=:minPrice AND f.price<=:maxPrice ORDER BY f."+orderBy+" "+order;
		TypedQuery<Flight> query = em.createQuery(jpql, Flight.class);
		query.setParameter("locationDepart", locationDepart);
		query.setParameter("locationArrival", locationArrival);
		query.setParameter("dateDepart", date1);
		query.setParameter("dateDepart2", date2);
		query.setParameter("stops", stops);
		query.setParameter("minPrice", minPrice);
		query.setParameter("maxPrice", maxPrice);
		try{
			flights = query.getResultList();
		}catch(NoResultException e){
			Logger.getLogger(getClass().getName())
			.log(Level.INFO, "no flight with this parameter");
		}
		return flights;
	}
	
	
	
	
	
	
	@Override
	public ArrayList<Flight> findFlightsRoundTripByLocationAndDate(
			String locationDepart, String locationArrival, String dateDepart,
			String dateReturn) {
		
		List<Flight> flights = null;
		List<Flight> flights2 = null;
		flights=findFlightsOneWayByLocationAndDate(locationDepart, locationArrival, dateDepart);
		if(flights.size()==0)
		{
			return null;
		}
		
		flights2=findFlightsOneWayByLocationAndDate(locationArrival, locationDepart, dateReturn);
		if(flights2.size()==0)
		{
			return null;
		}
		
		ArrayList<Flight> newList = new ArrayList<Flight>(flights);
		newList.addAll(flights2);
		
		return newList;		
		
	}

	
	



}
