package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Reservation
 *
 */

@Entity
@Table(name="t_reservation")

public class Reservation implements Serializable {

	   
	
	private Integer idReservation;
	private java.util.Date dateReservation;
	private String status;
	private String travelClass;
	
	
	
	private Flight flight;
	private List<Payment> payments;
	private Passanger passanger;
	private static final long serialVersionUID = 1L;

	public Reservation() {
	} 
	
	
	
	



	public Reservation(Date dateReservation, String status, String travelClass,
			Flight flight) {
		super();
		this.dateReservation = dateReservation;
		this.status = status;
		this.travelClass = travelClass;
		this.flight = flight;
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
	@JoinColumn( name= "flight_fk")
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	@OneToMany( mappedBy = "reservation",fetch=FetchType.EAGER)
	@XmlTransient
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
   
}
