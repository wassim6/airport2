package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PaymentStatus
 *
 */
@Entity
@Table(name="t_paymentStatus")

public class PaymentStatus implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPaymentStatus;
	private String PaymentStatusCode;
	private static final long serialVersionUID = 1L;

	public PaymentStatus() {
	}   
	
	public Integer getIdPaymentStatus() {
		return this.IdPaymentStatus;
	}

	public void setIdPaymentStatus(Integer IdPaymentStatus) {
		this.IdPaymentStatus = IdPaymentStatus;
	}   
	public String getPaymentStatusCode() {
		return this.PaymentStatusCode;
	}

	public void setPaymentStatusCode(String PaymentStatusCode) {
		this.PaymentStatusCode = PaymentStatusCode;
	}
   
}
