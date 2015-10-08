package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationStatus
 *
 */
@Entity
@Table(name="t_reservationStatus")

public class ReservationStatus implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdReservationStatus;
	private String ReservationStatusCode;
	private static final long serialVersionUID = 1L;

	public ReservationStatus() {
	}   
	public Integer getIdReservationStatus() {
		return this.IdReservationStatus;
	}

	public void setIdReservationStatus(Integer IdReservationStatus) {
		this.IdReservationStatus = IdReservationStatus;
	}   
	public String getReservationStatusCode() {
		return this.ReservationStatusCode;
	}

	public void setReservationStatusCode(String ReservationStatusCode) {
		this.ReservationStatusCode = ReservationStatusCode;
	}
   
}
