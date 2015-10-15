package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: AirlineCompany
 *
 */
@Entity
@Table(name="t_airlineCompany")

public class AirlineCompany implements Serializable {

	   
	
	private Integer idAirlineCompany;
	private String name;
	private String logo;
<<<<<<< HEAD
	private Double rate;
	private Integer totalRate;
=======
	private List<Feedback> feedbacks;
>>>>>>> branch 'master' of https://github.com/wassim6/airport2.git
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public AirlineCompany() {
	}   
	
	
	




	@Override
	public String toString() {
		return "AirlineCompany [idAirlineCompany=" + idAirlineCompany
				+ ", name=" + name + ", logo=" + logo + ", rate=" + rate
				+ ", totalRate=" + totalRate + "]";
	}







	public AirlineCompany(Integer idAirlineCompany, String name, String logo) {
		this.idAirlineCompany = idAirlineCompany;
		this.name = name;
		this.logo = logo;
		this.rate=0.0;
		this.totalRate=0;
	}



	public AirlineCompany(String name, String logo) {
		this.name = name;
		this.logo = logo;
		this.rate=0.0;
		this.totalRate=0;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdAirlineCompany() {
		return this.idAirlineCompany;
	}

	public void setIdAirlineCompany(Integer IdAirlineCompany) {
		this.idAirlineCompany = IdAirlineCompany;
	}   
	@Column(unique = true)
	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}   
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String Logo) {
		this.logo = Logo;
	}
	@OneToMany( mappedBy = "airlineCompany" )
	@XmlTransient
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}


<<<<<<< HEAD

	public Double getRate() {
		return rate;
	}



	public void setRate(Double rate) {
		this.rate = rate;
	}



	public Integer getTotalRate() {
		return totalRate;
	}



	public void setTotalRate(Integer totalRate) {
		this.totalRate = totalRate;
=======
	@OneToMany( mappedBy = "airline" )
	@XmlTransient
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}



	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
>>>>>>> branch 'master' of https://github.com/wassim6/airport2.git
	}
   
}
