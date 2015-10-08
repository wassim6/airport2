package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity
@Table(name="t_reservation")

public class Reservation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdReservation;
	private Date DateReservation;
	private String Status;
	private String TravelClass;
	@ManyToOne
	@JoinColumn( name= "reservationStatus_fk")
	private ReservationStatus ReservationStatusId;
	
	
	@ManyToOne
	@JoinColumn( name= "reservationType_fk")
	private ReservationType ReservationTypeId;
	@ManyToOne
	@JoinColumn( name= "flight_fk")
	private Flight FlightId;
	@ManyToOne
	@JoinColumn( name= "passanger_fk")
	private Passanger passanger;
	private static final long serialVersionUID = 1L;

	public Reservation() {
	}  
	
	
	public Integer getIdReservation() {
		return this.IdReservation;
	}

	public void setIdReservation(Integer IdReservation) {
		this.IdReservation = IdReservation;
	}   
	public Date getDateReservation() {
		return this.DateReservation;
	}

	public void setDateReservation(Date DateReservation) {
		this.DateReservation = DateReservation;
	}   
	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}   
	public String getTravelClass() {
		return this.TravelClass;
	}

	public void setTravelClass(String TravelClass) {
		this.TravelClass = TravelClass;
	}   
	
	
	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}

	
	public ReservationStatus getReservationStatusId() {
		return ReservationStatusId;
	}

	public void setReservationStatusId(ReservationStatus reservationStatusId) {
		ReservationStatusId = reservationStatusId;
	}

	
	
	public ReservationType getReservationTypeId() {
		return ReservationTypeId;
	}

	public void setReservationTypeId(ReservationType reservationTypeId) {
		ReservationTypeId = reservationTypeId;
	}

	
	public Flight getFlightId() {
		return FlightId;
	}

	public void setFlightId(Flight flightId) {
		FlightId = flightId;
	}
   
}
