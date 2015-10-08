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

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPayment;
	private Date PaymentDate;
	private Integer PaymentAmount;
	private PaymentStatus PaymentStatusId;
	private Reservation ReservationId;
	@ManyToOne
	@JoinColumn( name= "clientId_fk")
	private Client clientId;
	private static final long serialVersionUID = 1L;

	public Payment() {

	}   
	
	public Integer getIdPayment() {
		return this.IdPayment;
	}

	public void setIdPayment(Integer IdPayment) {
		this.IdPayment = IdPayment;
	}   
	public Date getPaymentDate() {
		return this.PaymentDate;
	}

	public void setPaymentDate(Date PaymentDate) {
		this.PaymentDate = PaymentDate;
	}   
	public Integer getPaymentAmount() {
		return this.PaymentAmount;
	}

	public void setPaymentAmount(Integer PaymentAmount) {
		this.PaymentAmount = PaymentAmount;
	}

	public PaymentStatus getPaymentStatusId() {
		return PaymentStatusId;
	}

	public void setPaymentStatusId(PaymentStatus paymentStatusId) {
		PaymentStatusId = paymentStatusId;
	}

	public Reservation getReservationId() {
		return ReservationId;
	}

	public void setReservationId(Reservation reservationId) {
		ReservationId = reservationId;
	}

	public Client getClient() {
		return clientId;
	}

	public void setClient(Client client) {
		clientId = client;
	}   
  
	
   
}
