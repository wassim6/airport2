package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;


import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payment
 *
 */

@Entity
@Table(name="t_payment")

public class Payment implements Serializable {

	   
	
	private Integer idPayment;
	private Date paymentDate;
	private Integer paymentAmount;
	private String paymentStatus;
	private Reservation reservation;
	
	private Client client;
	private static final long serialVersionUID = 1L;

	public Payment() {

	}   
	
	
	public Payment(Integer paymentAmount,
			String paymentStatus, Reservation reservation, Client client) {
		super();
		Date dateNow = new Date();
		this.paymentDate = dateNow;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
		this.reservation = reservation;
		this.client = client;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(Integer IdPayment) {
		this.idPayment = IdPayment;
	}   
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date PaymentDate) {
		this.paymentDate = PaymentDate;
	}   
	public Integer getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(Integer PaymentAmount) {
		this.paymentAmount = PaymentAmount;
	}

	
	@ManyToOne
	@JoinColumn( name= "reservationId_fk")
	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	@ManyToOne
	@JoinColumn( name= "clientId_fk")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}   
  
	
   
}
