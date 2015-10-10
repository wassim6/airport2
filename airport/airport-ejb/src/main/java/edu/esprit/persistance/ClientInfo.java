package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: ClientInfo
 *
 */
@Entity
@Table(name = "t_clientInfo")
public class ClientInfo implements Serializable {

	private Integer idClientInfo;
	private Integer milesParcoured;
	private String countriesVisited;
	private Integer numberTrips;

	private Client clientId;

	private static final long serialVersionUID = 1L;

	public ClientInfo() {

	}

	public ClientInfo(Integer milesParcoured, String countriesVisited,
			Integer numberTrips, Client client) {
		super();
		this.milesParcoured = milesParcoured;
		this.countriesVisited = countriesVisited;
		this.numberTrips = numberTrips;
		this.clientId = client;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdClientInfo() {
		return this.idClientInfo;
	}

	public void setIdClientInfo(Integer IdClientInfo) {
		this.idClientInfo = IdClientInfo;
	}

	public Integer getMilesParcoured() {
		return this.milesParcoured;
	}

	public void setMilesParcoured(Integer milesParcoured) {
		this.milesParcoured = milesParcoured;
	}

	public String getCountriesVisited() {
		return this.countriesVisited;
	}

	public void setCountriesVisited(String CountriesVisited) {
		this.countriesVisited = CountriesVisited;
	}

	public Integer getNumberTrips() {
		return numberTrips;
	}

	public void setNumberTrips(Integer numberTrips) {
		this.numberTrips = numberTrips;
	}

	
	@OneToOne
	@JoinColumn(insertable=true,name = "clientId_fk")
	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

}
