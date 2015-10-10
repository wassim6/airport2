package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@Table(name="t_client")

public class Client implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Integer phone;
	private Date createTime;
	@OneToMany( mappedBy = "client" )
	private List<Payment> payments;
	private static final long serialVersionUID = 1L;

	public Client() {
		
		
	}   
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer IdClient) {
		this.idClient = IdClient;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String Email) {
		this.email = Email;
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
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}   
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer Phone) {
		this.phone = Phone;
	}   
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date CreateTime) {
		this.createTime = CreateTime;
	}
	
   
}
