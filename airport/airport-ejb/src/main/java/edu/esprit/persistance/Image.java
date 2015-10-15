package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Image
 *
 */
@Entity
@Table(name="t_image")

public class Image implements Serializable {

	
	private Integer idImage;
	private byte[] image;
	private Client clientImage;
	private static final long serialVersionUID = 1L;

	public Image() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdImage() {
		return this.idImage;
	}

	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}
	
	
	
	
	@ManyToOne
	@JoinColumn( name= "clientImage_fk")
	public Client getClientImage() {
		return clientImage;
	}
	public void setClientImage(Client clientImage) {
		this.clientImage = clientImage;
	}

	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
   
}
