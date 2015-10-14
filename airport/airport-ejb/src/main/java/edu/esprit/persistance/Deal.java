package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Deals
 *
 */
@Entity
@Table(name="t_Deal")
public class Deal implements Serializable {

	   

	private Integer idDeal;
	private Date startDeal;
	private Date endDeal;
	private String description;
	private Flight  idFlight;
	private static final long serialVersionUID = 1L;

	public Deal() {
	
	}   
	
	
	
	@Override
	public String toString() {
		return "Deal [idDeal=" + idDeal + ", StartDeal=" + startDeal
				+ ", endDeal=" + endDeal + ", Description=" + description + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdDeal() {
		return this.idDeal;
	}

	public void setIdDeal(Integer idDeal) {
		this.idDeal = idDeal;
	}   
	public Date getStartDeal() {
		return this.startDeal;
	}

	public void setStartDeal(Date StartDeal) {
		this.startDeal = StartDeal;
	}   
	public Date getEndDeal() {
		return this.endDeal;
	}

	public void setEndDeal(Date endDeal) {
		this.endDeal = endDeal;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String Description) {
		this.description = Description;
	}



	
	
	@ManyToOne
	@JoinColumn( name= "idFlight_fk")
	
	public Flight getIdFlight() {
		return idFlight;
	}



	public void setIdFlight(Flight idFlight) {
		this.idFlight = idFlight;
	}
	
	
   
}
