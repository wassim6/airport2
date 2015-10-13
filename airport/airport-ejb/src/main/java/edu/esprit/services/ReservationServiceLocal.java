package edu.esprit.services;

import javax.ejb.Local;

import edu.esprit.persistance.Reservation;

@Local
public interface ReservationServiceLocal {
	
	public void CancelReservation(Reservation reservation) ;

}
