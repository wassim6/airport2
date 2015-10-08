package edu.esprit.persistance;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Plane
 *
 */
@Entity
@Table(name="t_plane")

public class Plane implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPlane;
	private String PlaneName;
	private Integer MaximumSpeed;
	private Integer EconomicSeats;
	private Integer BusinessSeats;
	private Integer FirstSeats;
	private Integer Wifi;
	private Integer Plug;
	@OneToMany( mappedBy = "PlaneId" )
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public Plane() {
	}   
	
	public Integer getIdPlane() {
		return this.IdPlane;
	}

	public void setIdPlane(Integer IdPlane) {
		this.IdPlane = IdPlane;
	}   
	public String getPlaneName() {
		return this.PlaneName;
	}

	public void setPlaneName(String PlaneName) {
		this.PlaneName = PlaneName;
	}   
	public Integer getMaximumSpeed() {
		return this.MaximumSpeed;
	}

	public void setMaximumSpeed(Integer MaximumSpeed) {
		this.MaximumSpeed = MaximumSpeed;
	}   
	public Integer getEconomicSeats() {
		return this.EconomicSeats;
	}

	public void setEconomicSeats(Integer EconomicSeats) {
		this.EconomicSeats = EconomicSeats;
	}   
	public Integer getBusinessSeats() {
		return this.BusinessSeats;
	}

	public void setBusinessSeats(Integer BusinessSeats) {
		this.BusinessSeats = BusinessSeats;
	}   
	public Integer getFirstSeats() {
		return this.FirstSeats;
	}

	public void setFirstSeats(Integer FirstSeats) {
		this.FirstSeats = FirstSeats;
	}   
	public Integer getWifi() {
		return this.Wifi;
	}

	public void setWifi(Integer Wifi) {
		this.Wifi = Wifi;
	}   
	public Integer getPlug() {
		return this.Plug;
	}

	public void setPlug(Integer Plug) {
		this.Plug = Plug;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
   
}
