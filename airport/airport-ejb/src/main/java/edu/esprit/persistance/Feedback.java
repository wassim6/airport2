package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feedback
 *
 */
@Entity
@Table(name="t_feedback")

public class Feedback implements Serializable {

	
	private Integer idFeedback;
	private String feedback;
	private Client clientId;
	private Date createTime;
	private Integer rate;
	private AirlineCompany airline;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		
	}   
	
	
	public Feedback(String feedback, Client clientId) {
		super();
		this.feedback = feedback;
		this.clientId = clientId;
	}
	
	


	public Feedback(String feedback, Client clientId, AirlineCompany airline) {
		super();
		this.feedback = feedback;
		this.clientId = clientId;
		this.airline = airline;
		this.createTime = new Date();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFeedback() {
		return this.idFeedback;
	}

	public void setIdFeedback(Integer idFeedback) {
		this.idFeedback = idFeedback;
	}   
	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	@ManyToOne
	@JoinColumn( name= "clientId_fk")
	public Client getClientId() {
		return clientId;
	}
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	@ManyToOne
	@JoinColumn( name= "airline_fk")
	public AirlineCompany getAirline() {
		return airline;
	}


	public void setAirline(AirlineCompany airline) {
		this.airline = airline;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		
		/*if(rate>5 || rate<1)
		{
			this.rate= 0;
		}*/
		this.rate = rate;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
   
}
