package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Time;
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
	private Integer IdClient;
	private String Email;
	private String FirstName;
	private String LastName;
	private String Password;
	private Integer Phone;
	private Time CreateTime;
	private ClientInfo clientInfo;
	@OneToMany( mappedBy = "clientId" )
	private List<Payment> payments;
	private static final long serialVersionUID = 1L;

	public Client() {
		
		
	}   
	public Integer getIdClient() {
		return this.IdClient;
	}

	public void setIdClient(Integer IdClient) {
		this.IdClient = IdClient;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
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
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public Integer getPhone() {
		return this.Phone;
	}

	public void setPhone(Integer Phone) {
		this.Phone = Phone;
	}   
	public Time getCreateTime() {
		return this.CreateTime;
	}

	public void setCreateTime(Time CreateTime) {
		this.CreateTime = CreateTime;
	}
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}
   
}
