package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_location")
public class Location implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idLocation;
	private String airportCode;
	private String country;
	private String city;
	private Integer zipCode;
	private String airportName;
	private Integer timeZone;
	
	public Location() {
	}
	
	public Location(String airportCode, String country, String city,
			Integer zipCode, String airportName, Integer timeZone) {
		this.airportCode = airportCode;
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.airportName = airportName;
		this.timeZone = timeZone;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}
	
	@Column(unique = true)
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public Integer getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(Integer timeZone) {
		this.timeZone = timeZone;
	}
	
	@Override
	public String toString() {
		return "Location [idLocation=" + idLocation + ", airportCode="
				+ airportCode + ", country=" + country + ", city=" + city
				+ ", zipCode=" + zipCode + ", airportName=" + airportName
				+ ", timeZone=" + timeZone + "]";
	}
	
	
	
}
