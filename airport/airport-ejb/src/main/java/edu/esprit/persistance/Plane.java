package edu.esprit.persistance;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Plane
 *
 */
@Entity
@Table(name="t_plane")

public class Plane implements Serializable {

	   
	
	private Integer idPlane;
	private String planeName;
	private Integer maximumSpeed;
	private Integer economicSeats;
	private Integer businessSeats;
	private Integer firstSeats;
	private Integer wifi;
	private Integer plug;
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public Plane() {
	}   
	
	
	
	public Plane(Integer idPlane, String planeName, Integer maximumSpeed,
			Integer economicSeats, Integer businessSeats, Integer firstSeats,
			Integer wifi, Integer plug) {
		this.idPlane = idPlane;
		this.planeName = planeName;
		this.maximumSpeed = maximumSpeed;
		this.economicSeats = economicSeats;
		this.businessSeats = businessSeats;
		this.firstSeats = firstSeats;
		this.wifi = wifi;
		this.plug = plug;
	}



	public Plane(String planeName, Integer maximumSpeed, Integer economicSeats,
			Integer businessSeats, Integer firstSeats, Integer wifi,
			Integer plug) {
		this.planeName = planeName;
		this.maximumSpeed = maximumSpeed;
		this.economicSeats = economicSeats;
		this.businessSeats = businessSeats;
		this.firstSeats = firstSeats;
		this.wifi = wifi;
		this.plug = plug;
	}



	@Override
	public String toString() {
		return "Plane [idPlane=" + idPlane + ", planeName=" + planeName
				+ ", maximumSpeed=" + maximumSpeed + ", economicSeats="
				+ economicSeats + ", businessSeats=" + businessSeats
				+ ", firstSeats=" + firstSeats + ", wifi=" + wifi + ", plug="
				+ plug + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPlane() {
		return this.idPlane;
	}

	public void setIdPlane(Integer IdPlane) {
		this.idPlane = IdPlane;
	}   
	public String getPlaneName() {
		return this.planeName;
	}

	public void setPlaneName(String PlaneName) {
		this.planeName = PlaneName;
	}   
	public Integer getMaximumSpeed() {
		return this.maximumSpeed;
	}

	public void setMaximumSpeed(Integer MaximumSpeed) {
		this.maximumSpeed = MaximumSpeed;
	}   
	public Integer getEconomicSeats() {
		return this.economicSeats;
	}

	public void setEconomicSeats(Integer EconomicSeats) {
		this.economicSeats = EconomicSeats;
	}   
	public Integer getBusinessSeats() {
		return this.businessSeats;
	}

	public void setBusinessSeats(Integer BusinessSeats) {
		this.businessSeats = BusinessSeats;
	}   
	public Integer getFirstSeats() {
		return this.firstSeats;
	}

	public void setFirstSeats(Integer FirstSeats) {
		this.firstSeats = FirstSeats;
	}   
	public Integer getWifi() {
		return this.wifi;
	}

	public void setWifi(Integer Wifi) {
		this.wifi = Wifi;
	}   
	public Integer getPlug() {
		return this.plug;
	}

	public void setPlug(Integer Plug) {
		this.plug = Plug;
	}
	
	@XmlTransient
	@OneToMany( mappedBy = "plane")
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
   
}
