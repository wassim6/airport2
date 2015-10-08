package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AirlineCompany
 *
 */
@Entity
@Table(name="t_airlineCompany")

public class AirlineCompany implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdAirlineCompany;
	private String Name;
	private String Logo;
	@OneToMany( mappedBy = "AirlineCompanyId" )
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public AirlineCompany() {
		
		
	}   
	public Integer getIdAirlineCompany() {
		return this.IdAirlineCompany;
	}

	public void setIdAirlineCompany(Integer IdAirlineCompany) {
		this.IdAirlineCompany = IdAirlineCompany;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getLogo() {
		return this.Logo;
	}

	public void setLogo(String Logo) {
		this.Logo = Logo;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
   
}
