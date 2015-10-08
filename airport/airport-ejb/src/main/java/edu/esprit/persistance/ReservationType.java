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
@Table(name="t_reservationType")

public class ReservationType implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdReservationType;
	private String ReservationTypeName;
	private String Description;
	private static final long serialVersionUID = 1L;

	public ReservationType() {

	}   
	
	public Integer getIdReservationType() {
		return this.IdReservationType;
	}

	public void setIdReservationType(Integer IdReservationType) {
		this.IdReservationType = IdReservationType;
	}   
	public String getReservationTypeName() {
		return this.ReservationTypeName;
	}

	public void setReservationTypeName(String ReservationTypeName) {
		this.ReservationTypeName = ReservationTypeName;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
