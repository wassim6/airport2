package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name = "t_flight")
public class Flight implements Serializable {

	private Integer idFlight;
	private String flightNumber;
	private Date departDate;
	private Date arrivalDate;
	private Integer flightDuration;
	private Integer flightMiles;
	private Integer numberStops;
	private Integer availableEconomicSeats;
	private Integer availableBusinessSeats;
	private Integer availableFirstSeats;

	private Plane plane;

	private AirlineCompany airlineCompany;
	private static final long serialVersionUID = 1L;

	public Flight() {
	}


	@Override
	public String toString() {
		return "Flight [idFlight=" + idFlight + ", flightNumber="
				+ flightNumber 
				+ ", departDate="
				+ departDate + ", arrivalDate=" + arrivalDate
				+ ", flightDuration=" + flightDuration + ", flightMiles="
				+ flightMiles + ", numberStops=" + numberStops
				+ ", availableEconomicSeats=" + availableEconomicSeats
				+ ", availableBusinessSeats=" + availableBusinessSeats
				+ ", availableFirstSeats=" + availableFirstSeats + ", plane="
				+ plane + ", airlineCompany=" + airlineCompany + "]";
	}
	
	public Flight(String flightNumber,
			 Date departDate, Date arrivalDate,
			Integer flightDuration, Integer flightMiles, Integer numberStops,
			Plane plane, AirlineCompany airlineCompany) {

		this.flightNumber = flightNumber;
		this.departDate = departDate;
		this.arrivalDate = arrivalDate;
		this.flightDuration = flightDuration;
		this.flightMiles = flightMiles;
		this.numberStops = numberStops;
		this.plane = plane;
		this.airlineCompany = airlineCompany;

		this.availableEconomicSeats = this.plane.getEconomicSeats();
		this.availableBusinessSeats = this.plane.getBusinessSeats();
		this.availableFirstSeats = this.plane.getFirstSeats();
	}

	public Flight(Integer idFlight, String flightNumber,
			 Date departDate,
			Date arrivalDate, Integer flightDuration, Integer flightMiles,
			Integer numberStops, Integer availableEconomicSeats,
			Integer availableBusinessSeats, Integer availableFirstSeats,
			Plane plane, AirlineCompany airlineCompany) {
		this.idFlight = idFlight;
		this.flightNumber = flightNumber;
		this.departDate = departDate;
		this.arrivalDate = arrivalDate;
		this.flightDuration = flightDuration;
		this.flightMiles = flightMiles;
		this.numberStops = numberStops;
		this.plane = plane;
		this.airlineCompany = airlineCompany;

		this.availableEconomicSeats = this.plane.getEconomicSeats();
		this.availableBusinessSeats = this.plane.getBusinessSeats();
		this.availableFirstSeats = this.plane.getFirstSeats();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFlight() {
		return this.idFlight;
	}

	public void setIdFlight(Integer IdFlight) {
		this.idFlight = IdFlight;
	}

	@Column(unique = true)
	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setFlightNumber(String FlightNumber) {
		this.flightNumber = FlightNumber;
	}

	public Date getDepartDate() {
		return this.departDate;
	}

	public void setDepartDate(Date DepartDate) {
		this.departDate = DepartDate;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Date ArrivalDate) {
		this.arrivalDate = ArrivalDate;
	}

	public Integer getFlightDuration() {
		return this.flightDuration;
	}

	public void setFlightDuration(Integer FlightDuration) {
		this.flightDuration = FlightDuration;
	}

	public Integer getFlightMiles() {
		return this.flightMiles;
	}

	public void setFlightMiles(Integer FlightMiles) {
		this.flightMiles = FlightMiles;
	}

	public Integer getNumberStops() {
		return this.numberStops;
	}

	public void setNumberStops(Integer NumberStops) {
		this.numberStops = NumberStops;
	}

	public Integer getAvailableEconomicSeats() {
		return this.availableEconomicSeats;
	}

	public void setAvailableEconomicSeats(Integer AvailableEconomicSeats) {
		this.availableEconomicSeats = AvailableEconomicSeats;
	}

	public Integer getAvailableBusinessSeats() {
		return this.availableBusinessSeats;
	}

	public void setAvailableBusinessSeats(Integer AvailableBusinessSeats) {
		this.availableBusinessSeats = AvailableBusinessSeats;
	}

	public Integer getAvailableFirstSeats() {
		return this.availableFirstSeats;
	}

	public void setAvailableFirstSeats(Integer AvailableFirstSeats) {
		this.availableFirstSeats = AvailableFirstSeats;
	}

	@ManyToOne
	@JoinColumn(name = "airlineCompanyId_fk")
	public AirlineCompany getAirlineCompany() {
		return airlineCompany;
	}

	public void setAirlineCompany(AirlineCompany airlineCompany) {
		this.airlineCompany = airlineCompany;
	}

	

/*	@ManyToOne
	@JoinColumn(name = "arrivalLocationId_fk", referencedColumnName = "locationId")
	public Location getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(Location arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}*/

	@ManyToOne
	@JoinColumn(name = "planeId_fk")
	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

}
