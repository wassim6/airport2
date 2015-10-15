package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="t_employee")

public class Employee implements Serializable {

	
	private Integer idEmployee;
	private String firstName;
	private String lastName;
	private String Job;
	private String email;
	private Flight flightId;
	
	
	private static final long serialVersionUID = 1L;

	public Employee() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getJob() {
		return this.Job;
	}

	public void setJob(String Job) {
		this.Job = Job;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@ManyToOne
	@JoinColumn( name= "flightId_fk")
	public Flight getFlightId() {
		return flightId;
	}


	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}


}
