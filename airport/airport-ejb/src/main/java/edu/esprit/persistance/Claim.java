package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity
@Table(name="t_Claim")

public class Claim implements Serializable {

	
	private Integer idClaim;
	private String subject;
	private String Claim;
	private Client clientClaim;
	private static final long serialVersionUID = 1L;

	public Claim() {
		
	} 
	
	
	
	public Claim(String claim, Client clientClaim) {
		super();
		Claim = claim;
		this.clientClaim = clientClaim;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdClaim() {
		return this.idClaim;
	}

	public void setIdClaim(Integer idClaim) {
		this.idClaim = idClaim;
	}   
	public String getClaim() {
		return this.Claim;
	}

	public void setClaim(String Claim) {
		this.Claim = Claim;
	}
	@ManyToOne
	@JoinColumn( name= "clientClaim_fk")
	public Client getClientClaim() {
		return clientClaim;
	}
	public void setClientClaim(Client clientId) {
		this.clientClaim = clientId;
	}

	@Override
	public String toString() {
		return "Claim [idClaim=" + idClaim + ", Claim=" + Claim + "]";
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}
   
   
	
}
