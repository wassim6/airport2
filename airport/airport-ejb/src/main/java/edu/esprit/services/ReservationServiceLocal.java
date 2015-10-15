package edu.esprit.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.persistance.Reservation;

@Local
public interface ReservationServiceLocal {
	
	public void CancelReservation(Reservation reservation) ;
	
	
	public void Reserver(Reservation reservation);
    
    public Reservation find(Integer id);
    
    public List <Reservation> ConsultAll(Integer id);

    
    public List <Reservation> FindByYear(String year);
    
    public List <Reservation> FindByPlace(String code);
    
	public void update(Reservation reservation);

	

}