package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;

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
	private PaymentStatus paymentStatus;
	private Reservation reservation;
	
	private Client client;
	private static final long serialVersionUID = 1L;

	public Payment() {

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

	public PaymentStatus getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

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
  
	
   
}
