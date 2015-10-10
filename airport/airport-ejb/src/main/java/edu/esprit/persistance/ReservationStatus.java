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

	   
	
	private Integer idReservationStatus;
	private String reservationStatusCode;
	private static final long serialVersionUID = 1L;

	public ReservationStatus() {
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdReservationStatus() {
		return this.idReservationStatus;
	}

	public void setIdReservationStatus(Integer IdReservationStatus) {
		this.idReservationStatus = IdReservationStatus;
	}   
	public String getReservationStatusCode() {
		return this.reservationStatusCode;
	}

	public void setReservationStatusCode(String ReservationStatusCode) {
		this.reservationStatusCode = ReservationStatusCode;
	}
   
}
