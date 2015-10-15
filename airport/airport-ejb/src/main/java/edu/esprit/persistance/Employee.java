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
	private String email;
	
	private List<Affectation> affectations;
	
	
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
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany( mappedBy = "employee")
	public List<Affectation> getAffectations() {
		return affectations;
	}



	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}






}
