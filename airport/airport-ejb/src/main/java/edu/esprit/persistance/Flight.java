package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Time;







import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name="t_flight")

public class Flight implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdFlight;
	private Integer FlightNumber;
	@ManyToOne
	@JoinColumn( name= "departLocationId_fk")
	private Location DepartLocationId;
	@ManyToOne
	@JoinColumn( name= "arrivalLocationId_fk")
	private Location ArrivalLocationId;
	private Time DepartTime;
	private Time ArrivalTime;
	private Integer FlightDuration;
	private Integer FlightMiles;
	private Integer NumberStops;
	private Integer AvailableEconomicSeats;
	private Integer AvailableBusinessSeats;
	private Integer AvailableFirstSeats;
	@ManyToOne
	@JoinColumn( name= "planeId_fk")
	private Plane PlaneId;
	@ManyToOne
	@JoinColumn( name= "airlineCompanyId_fk")
	private AirlineCompany AirlineCompanyId;
	private static final long serialVersionUID = 1L;

	public Flight() {
	}   
	
	public Integer getIdFlight() {
		return this.IdFlight;
	}

	public void setIdFlight(Integer IdFlight) {
		this.IdFlight = IdFlight;
	}   
	public Integer getFlightNumber() {
		return this.FlightNumber;
	}

	public void setFlightNumber(Integer FlightNumber) {
		this.FlightNumber = FlightNumber;
	}   
	
	public Time getDepartTime() {
		return this.DepartTime;
	}

	public void setDepartTime(Time DepartTime) {
		this.DepartTime = DepartTime;
	}   
	public Time getArrivalTime() {
		return this.ArrivalTime;
	}

	public void setArrivalTime(Time ArrivalTime) {
		this.ArrivalTime = ArrivalTime;
	}   
	public Integer getFlightDuration() {
		return this.FlightDuration;
	}

	public void setFlightDuration(Integer FlightDuration) {
		this.FlightDuration = FlightDuration;
	}   
	public Integer getFlightMiles() {
		return this.FlightMiles;
	}

	public void setFlightMiles(Integer FlightMiles) {
		this.FlightMiles = FlightMiles;
	}   
	public Integer getNumberStops() {
		return this.NumberStops;
	}

	public void setNumberStops(Integer NumberStops) {
		this.NumberStops = NumberStops;
	}   
	public Integer getAvailableEconomicSeats() {
		return this.AvailableEconomicSeats;
	}

	public void setAvailableEconomicSeats(Integer AvailableEconomicSeats) {
		this.AvailableEconomicSeats = AvailableEconomicSeats;
	}   
	public Integer getAvailableBusinessSeats() {
		return this.AvailableBusinessSeats;
	}

	public void setAvailableBusinessSeats(Integer AvailableBusinessSeats) {
		this.AvailableBusinessSeats = AvailableBusinessSeats;
	}   
	public Integer getAvailableFirstSeats() {
		return this.AvailableFirstSeats;
	}

	public void setAvailableFirstSeats(Integer AvailableFirstSeats) {
		this.AvailableFirstSeats = AvailableFirstSeats;
	}   
	
	public AirlineCompany getAirlineCompanyId() {
		return AirlineCompanyId;
	}

	public void setAirlineCompanyId(AirlineCompany airlineCompanyId) {
		this.AirlineCompanyId = airlineCompanyId;
	}

	public Location getDepartLocationId() {
		return DepartLocationId;
	}

	public void setDepartLocationId(Location departLocationId) {
		DepartLocationId = departLocationId;
	}

	public Location getArrivalLocationId() {
		return ArrivalLocationId;
	}

	public void setArrivalLocationId(Location arrivalLocationId) {
		ArrivalLocationId = arrivalLocationId;
	}

	public Plane getPlaneId() {
		return PlaneId;
	}

	public void setPlaneId(Plane planeId) {
		PlaneId = planeId;
	}
   
}
