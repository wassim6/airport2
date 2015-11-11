package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Client
 *
 */

@Entity()
@Table(name="t_client")

@XmlRootElement(name = "client")
public class Client implements Serializable {
	
	private Integer idClient;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Integer phone;
	private Date createTime;
	private Integer milesParcoured;
	private String countriesVisited;
	private Integer numberTrips;
	private List<Image> images;
	private List<Payment> payments;
	private List<Feedback> feedbacks;
	private List<Claim> claims;
	private static final long serialVersionUID = 1L;

	public Client() {
		
	}   




	



	




	public Client(String email, String firstName, String lastName,
			String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createTime = new Date();
	}













	
	

	public Client(String email, String firstName, String lastName,
			Integer milesParcoured,
			Integer numberTrips,String password, Integer phone) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phone = phone;
		this.milesParcoured = milesParcoured;
		this.numberTrips = numberTrips;
		
	}













	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer IdClient) {
		this.idClient = IdClient;
	}
	@Column(unique=true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}   
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer Phone) {
		this.phone = Phone;
	}   
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date CreateTime) {
		this.createTime = CreateTime;
	}
	
	@OneToMany( mappedBy = "client",fetch = FetchType.EAGER)
	@XmlTransient
	public List<Payment> getPayments() {
		return payments;
	}



	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}



	@OneToMany( mappedBy = "clientId",fetch = FetchType.EAGER)
	@XmlTransient
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}




	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	@XmlTransient
	@OneToMany( mappedBy = "clientClaim",fetch = FetchType.EAGER)
	public List<Claim> getClaims() {
		return claims;
	}

	


	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}



	@OneToMany( mappedBy = "clientImage",fetch = FetchType.EAGER)
	@XmlTransient
	public List<Image> getImages() {
		return images;
	}




	public void setImages(List<Image> images) {
		this.images = images;
	}




	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", phone=" + phone
				+ ", createTime=" + createTime + "]";
	}




	public Integer getMilesParcoured() {
		return milesParcoured;
	}




	public void setMilesParcoured(Integer milesParcoured) {
		this.milesParcoured = milesParcoured;
	}




	public String getCountriesVisited() {
		return countriesVisited;
	}




	public void setCountriesVisited(String countriesVisited) {
		this.countriesVisited = countriesVisited;
	}




	public Integer getNumberTrips() {
		return numberTrips;
	}




	public void setNumberTrips(Integer numberTrips) {
		this.numberTrips = numberTrips;
	}
   
	
	
}
