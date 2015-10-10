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
	private Integer idAirlineCompany;
	@Column(unique = true)
	private String name;
	private String logo;
	@OneToMany( mappedBy = "airlineCompany" )
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public AirlineCompany() {
	}   
	
	
	
	public AirlineCompany(Integer idAirlineCompany, String name, String logo) {
		this.idAirlineCompany = idAirlineCompany;
		this.name = name;
		this.logo = logo;
	}



	public AirlineCompany(String name, String logo) {
		this.name = name;
		this.logo = logo;
	}



	public Integer getIdAirlineCompany() {
		return this.idAirlineCompany;
	}

	public void setIdAirlineCompany(Integer IdAirlineCompany) {
		this.idAirlineCompany = IdAirlineCompany;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}   
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String Logo) {
		this.logo = Logo;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
   
}
