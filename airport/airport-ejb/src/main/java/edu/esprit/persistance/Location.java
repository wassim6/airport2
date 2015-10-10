package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Location
 *
 */
@Entity
@Table(name="t_location")

public class Location implements Serializable {

	   
	@Id
	private String locationCode;
	private String country;
	private String city;
	private Integer zipCode;
	private String airportName;
	@OneToMany( mappedBy = "ArrivalLocationId" )
	private List<Flight> flights;
	private Integer timeZone;
	
	private static final long serialVersionUID = 1L;

	public Location() {
		
	} 
	
	public Location(String locationCode, String country, String city,
			 		Integer zipCode, String airportName, Integer timeZone) {
		
		
		this.country = country;
		this.city = city;
		this.locationCode = locationCode;
		this.zipCode = zipCode;
		this.airportName = airportName;
		this.timeZone=timeZone;
	}

	

	   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}   
	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer ZipCode) {
		this.zipCode = ZipCode;
	}   
	public String getAirportName() {
		return this.airportName;
	}

	public void setAirportName(String AirportName) {
		this.airportName = AirportName;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Integer getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Integer timeZone) {
		this.timeZone = timeZone;
	}
   
}
