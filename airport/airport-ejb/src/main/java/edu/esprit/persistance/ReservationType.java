package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationType
 *
 */

@Entity
@Table(name = "t_reservationType")
public class ReservationType implements Serializable {

	private Integer idReservationType;
	private String reservationTypeName;
	private String description;
	private static final long serialVersionUID = 1L;

	public ReservationType() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdReservationType() {
		return this.idReservationType;
	}

	public void setIdReservationType(Integer IdReservationType) {
		this.idReservationType = IdReservationType;
	}

	public String getReservationTypeName() {
		return this.reservationTypeName;
	}

	public void setReservationTypeName(String ReservationTypeName) {
		this.reservationTypeName = ReservationTypeName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String Description) {
		this.description = Description;
	}

}
