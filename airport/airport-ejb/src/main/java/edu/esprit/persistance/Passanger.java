package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: client
 *
 */
@Entity
@Table(name="t_passanger")

public class Passanger implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPassanger;
	private String FirstName;
	private String LastName;
	private Integer PassportNumber;
	private Integer Phone;
	private String Address;
	private Integer Old;
	private String Email;
	private String State;
	private String City;
	private String Country;
	@OneToMany( mappedBy = "passanger" )
	private List <Reservation> reservations;
	private static final long serialVersionUID = 1L;

	public Passanger() {
	}   
	
	public Integer getIdPassanger() {
		return this.IdPassanger;
	}

	public void setIdPassanger(Integer IdPassanger) {
		this.IdPassanger = IdPassanger;
	}   
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public Integer getPhone() {
		return this.Phone;
	}

	public void setPhone(Integer Phone) {
		this.Phone = Phone;
	}   
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}   
	public Integer getOld() {
		return this.Old;
	}

	public void setOld(Integer Old) {
		this.Old = Old;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getState() {
		return this.State;
	}

	public void setState(String State) {
		this.State = State;
	}   
	public String getCity() {
		return this.City;
	}

	public void setCity(String City) {
		this.City = City;
	}   
	public String getCountry() {
		return this.Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}
	public Integer getPassportNumber() {
		return PassportNumber;
	}
	public void setPassportNumber(Integer passportNumber) {
		PassportNumber = passportNumber;
	}

	public List <Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List <Reservation> reservations) {
		this.reservations = reservations;
	}
   
}
