package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservation
 *
 */

@Entity
@Table(name="t_reservation")

public class Reservation implements Serializable {

	   
	
	private Integer idReservation;
	private Date dateReservation;
	private String status;
	private String travelClass;
	
	private ReservationStatus reservationStatus;
	
	
	
	private ReservationType reservationType;
	
	private Flight flight;
	private List<Payment> payments;
	private Passanger passanger;
	private static final long serialVersionUID = 1L;

	public Reservation() {
	}  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdReservation() {
		return this.idReservation;
	}

	public void setIdReservation(Integer IdReservation) {
		this.idReservation = IdReservation;
	}   
	public Date getDateReservation() {
		return this.dateReservation;
	}

	public void setDateReservation(Date DateReservation) {
		this.dateReservation = DateReservation;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String Status) {
		this.status = Status;
	}   
	public String getTravelClass() {
		return this.travelClass;
	}

	public void setTravelClass(String TravelClass) {
		this.travelClass = TravelClass;
	}   
	
	@ManyToOne
	@JoinColumn( name= "passanger_fk")
	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}

	@ManyToOne
	@JoinColumn( name= "reservationStatus_fk")
	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	
	@ManyToOne
	@JoinColumn( name= "reservationType_fk")
	public ReservationType getReservationType() {
		return reservationType;
	}

	public void setReservationType(ReservationType reservationType) {
		this.reservationType = reservationType;
	}

	@ManyToOne
	@JoinColumn( name= "flight_fk")
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@OneToMany( mappedBy = "reservation")
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
   
}
