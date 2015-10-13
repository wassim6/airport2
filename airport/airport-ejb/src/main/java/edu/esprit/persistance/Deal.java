package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Deals
 *
 */
@Entity
@Table(name="t_Deal")
public class Deal implements Serializable {

	   

	private Integer idDeal;
	private Date StartDeal;
	private Date endDeal;
	private String Description;
	private Flight  idFlight;
	private static final long serialVersionUID = 1L;

	public Deal() {
	
	}   
	
	
	
	@Override
	public String toString() {
		return "Deal [idDeal=" + idDeal + ", StartDeal=" + StartDeal
				+ ", endDeal=" + endDeal + ", Description=" + Description + "]";
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
		return this.StartDeal;
	}

	public void setStartDeal(Date StartDeal) {
		this.StartDeal = StartDeal;
	}   
	public Date getEndDeal() {
		return this.endDeal;
	}

	public void setEndDeal(Date endDeal) {
		this.endDeal = endDeal;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
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
