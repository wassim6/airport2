package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: client
 *
 */

@Entity
@Table(name = "t_passanger")
public class Passanger implements Serializable {

	private Integer idPassanger;
	private String firstName;
	private String lastName;
	private String passportNumber;
	private Date dateOfBirth;
	private Reservation reservations;
	private static final long serialVersionUID = 1L;

	public Passanger() {
	}
	
	

	public Passanger(String firstName, String lastName, String passportNumber,
			Date dateOfBirth, Reservation reservations) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.dateOfBirth = dateOfBirth;
		this.reservations=reservations;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPassanger() {
		return this.idPassanger;
	}

	public void setIdPassanger(Integer IdPassanger) {
		this.idPassanger = IdPassanger;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	//@OneToMany(mappedBy = "passanger")
	@ManyToOne
	@JoinColumn( name= "reservation_fk")
	public Reservation getReservations() {
		return reservations;
	}

	public void setReservations(Reservation reservations) {
		this.reservations = reservations;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
