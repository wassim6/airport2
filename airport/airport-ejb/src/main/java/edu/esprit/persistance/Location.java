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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdLocation;
	private String country;
	private String city;
	private String LocationCode;
	private Integer ZipCode;
	private String AirportName;
	@OneToMany( mappedBy = "ArrivalLocationId" )
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public Location() {
		
	} 
	
	public Location(String country, String city,
			String locationCode, Integer zipCode, String airportName) {
		
		
		this.country = country;
		this.city = city;
		this.LocationCode = locationCode;
		ZipCode = zipCode;
		AirportName = airportName;
	}

	public Integer getIdLocation() {
		return this.IdLocation;
	}

	public void setIdLocation(Integer IdLocation) {
		this.IdLocation = IdLocation;
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
		return this.LocationCode;
	}

	public void setLocationCode(String locationCode) {
		this.LocationCode = locationCode;
	}   
	public Integer getZipCode() {
		return this.ZipCode;
	}

	public void setZipCode(Integer ZipCode) {
		this.ZipCode = ZipCode;
	}   
	public String getAirportName() {
		return this.AirportName;
	}

	public void setAirportName(String AirportName) {
		this.AirportName = AirportName;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
   
}
