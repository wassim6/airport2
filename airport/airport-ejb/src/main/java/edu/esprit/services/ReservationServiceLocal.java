package edu.esprit.services;

import javax.ejb.Local;

@Local
public interface ReservationServiceLocal {
	
	public void CancelReservation();

}
