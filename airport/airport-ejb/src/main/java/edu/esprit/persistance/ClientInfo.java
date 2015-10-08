package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClientInfo
 *
 */
@Entity
@Table(name="t_clientInfo")

public class ClientInfo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdClientInfo;
	private Integer milesParcoured;
	private String CountriesVisited;
	private Integer NumberTrips;
	
	private static final long serialVersionUID = 1L;

	public ClientInfo() {
		
	}   
	public Integer getIdClientInfo() {
		return this.IdClientInfo;
	}

	public void setIdClientInfo(Integer IdClientInfo) {
		this.IdClientInfo = IdClientInfo;
	}   
	public Integer getMilesParcoured() {
		return this.milesParcoured;
	}

	public void setMilesParcoured(Integer milesParcoured) {
		this.milesParcoured = milesParcoured;
	}   
	public String getCountriesVisited() {
		return this.CountriesVisited;
	}

	public void setCountriesVisited(String CountriesVisited) {
		this.CountriesVisited = CountriesVisited;
	}
	public Integer getNumberTrips() {
		return NumberTrips;
	}
	public void setNumberTrips(Integer numberTrips) {
		NumberTrips = numberTrips;
	}
	
	
   
}
