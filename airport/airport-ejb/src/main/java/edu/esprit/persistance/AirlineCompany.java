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
	private String address;
	private String siteWeb;
	private String continent;
	private String contry;
	private String phone;
	private List<Feedback> feedbacks;
	private List<Flight> flights;
	private static final long serialVersionUID = 1L;

	public AirlineCompany() {
	}   
	
	
	




	




	




	

	@Override
	public String toString() {
		return "AirlineCompany [name=" + name + ", logo=" + logo + ", address="
				+ address + ", siteWeb=" + siteWeb + ", continent=" + continent
				+ ", contry=" + contry + ", phone=" + phone + "]";
	}



















	public AirlineCompany(String name, String logo, String address,
			String siteWeb, String continent, String contry, String phone) {
		super();
		this.name = name;
		this.logo = logo;
		this.address = address;
		this.siteWeb = siteWeb;
		this.continent = continent;
		this.contry = contry;
		this.phone = phone;
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


	
	
	@OneToMany( mappedBy = "airline" )
	@XmlTransient
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}



	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}







	public String getAddress() {
		return address;
	}







	public void setAddress(String address) {
		this.address = address;
	}







	public String getSiteWeb() {
		return siteWeb;
	}







	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}







	public String getContinent() {
		return continent;
	}







	public void setContinent(String continent) {
		this.continent = continent;
	}







	public String getContry() {
		return contry;
	}







	public void setContry(String contry) {
		this.contry = contry;
	}







	public String getPhone() {
		return phone;
	}







	public void setPhone(String phone) {
		this.phone = phone;
	}
   
}
