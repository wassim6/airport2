package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Affectation
 *
 */
@Entity
@Table(name="t_Affectation")

public class Affectation implements Serializable {

	
	private String job;
	private AffectationPk pk;
	
	
	private Employee employee;
	private Flight flight;
	
	
	private static final long serialVersionUID = 1L;

	public Affectation() {
		
	}   
	@EmbeddedId
	
	public AffectationPk getPk() {
		return pk;
	}
	public void setPk(AffectationPk pk) {
		this.pk = pk;
	}


	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@ManyToOne
	@JoinColumn( name = "employee_fk", insertable = false, updatable = false)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	@ManyToOne
	@JoinColumn( name = "flight_fk", insertable = false, updatable = false)
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
   
}
